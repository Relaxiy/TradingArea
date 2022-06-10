package com.example.cars.registration.presentation.register

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.CarApplication
import com.example.cars.app.presentation.personalPage.UserSharedViewModel
import com.example.cars.databinding.ActivityRegisterBinding
import com.example.cars.registration.presentation.login.LoginActivity
import com.example.cars.registration.presentation.register.actionSelector.RegistrationActionSelector.*
import com.example.cars.utils.sharedPrefs.SharedPreferencesManager
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.openActivity
import com.example.cars.utils.ext.parsePhoneNumber
import kotlinx.android.synthetic.main.activity_register.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class RegisterActivity : AppCompatActivity() {


    private val registerActivityViewModel: RegisterActivityViewModel by viewModels {
        CarApplication.appComponentWithSharedViewModel.viewModelsFactory()
    }

    @Inject
    lateinit var sharedPreferences: SharedPreferencesManager

    @Inject
    lateinit var userSharedViewModel: UserSharedViewModel

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.inputPhoneNumber.parsePhoneNumber()
        CarApplication.appComponentWithSharedViewModel.inject(this)
    }

    override fun onStart() {
        super.onStart()
        initDate()
        register()
        toLogin()
    }

    private fun initDate() {
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            updateLabel(calendar, inputDate)
        }
        inputDate.setOnClickListener {
            DatePickerDialog(
                this,
                datePicker,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
            ).show()
        }
    }

    private fun updateLabel(calendar: Calendar, inputDate: EditText) {
        val format = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(format, Locale.UK)
        inputDate.setText(sdf.format(calendar.time))
    }

    private fun register() {
        registrationButton.setOnClickListener {
            registerActivityViewModel.saveAccount(
                binding.inputUsername.text.toString(),
                binding.inputEmail.text.toString(),
                binding.inputPhoneNumber.text.toString(),
                binding.inputDate.text.toString(),
                binding.inputPasswordFirst.text.toString(),
                binding.inputPasswordSecond.text.toString()
            )
        }
        registerActivityViewModel.result.observe(this) { registrationActionSelector ->
            when (registrationActionSelector) {
                is OpenMainActivity -> {
                    sharedPreferences.saveSign( true)
                    sharedPreferences.saveEmail(binding.inputEmail.text.toString())
                    sharedPreferences.savePassword(binding.inputPasswordFirst.text.toString())
                    openActivity(LoginActivity::class.java)
                }
                is ShowInvalidInputDialog -> dialog(ShowInvalidInputDialog.MESSAGE)
                is ShowExistingEmailDialog -> dialog(ShowExistingEmailDialog.MESSAGE)
            }
        }
    }

    private fun toLogin() {
        toLogin.setOnClickListener {
            openActivity(LoginActivity::class.java)
        }
    }
}