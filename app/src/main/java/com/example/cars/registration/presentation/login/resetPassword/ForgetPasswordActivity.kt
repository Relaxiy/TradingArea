package com.example.cars.registration.presentation.login.resetPassword

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.CarApplication
import com.example.cars.databinding.ActivityForgetPasswordBinding
import com.example.cars.registration.presentation.login.LoginActivity
import com.example.cars.registration.presentation.login.resetPassword.actionSelectors.ChangingPasswordResult.*
import com.example.cars.registration.presentation.login.resetPassword.actionSelectors.FindByPhoneNumberResult.*
import com.example.cars.registration.presentation.login.resetPassword.actionSelectors.FindByPhoneNumberResult.ServerException
import com.example.cars.registration.presentation.login.resetPassword.actionSelectors.SendingCodeResult.*
import com.example.cars.utils.sharedPrefs.SharedPreferencesManager
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.openActivity
import com.example.cars.utils.ext.parsePhoneNumber
import com.example.cars.utils.ext.toLiteVersionPhoneNumber
import javax.inject.Inject

class ForgetPasswordActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferencesManager

    lateinit var binding : ActivityForgetPasswordBinding

    private val forgetPasswordActivityViewModel: ForgetPasswordActivityViewModel by viewModels {
        CarApplication.appComponentWithSharedViewModel.viewModelsFactory()
    }

    private var permissionCheck = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sendPhone.parsePhoneNumber()
        checkPermission()
        CarApplication.appComponentWithSharedViewModel.inject(this)
    }

    private fun checkPermission(){
        val requestSinglePermission = registerForActivityResult(
            ActivityResultContracts.RequestPermission()) {
            permissionCheck = it
        }
        if (!permissionCheck) {
            requestSinglePermission.launch(Manifest.permission.SEND_SMS)
            registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) {
                permissionCheck = it
            }
        }
    }

    override fun onStart() {
        super.onStart()
        sendMessage()
        observeSendMessageResult()
        observeCodeResult()
        observeChangingPassword()
    }

    private fun sendMessage() {
        binding.send.setOnClickListener {
            if (binding.code.visibility == EditText.INVISIBLE && binding.changePassword.visibility == EditText.INVISIBLE) {
                binding.progressForgetEntity.visibility = ProgressBar.VISIBLE
                forgetPasswordActivityViewModel.sendEmail(binding.sendPhone.text.toString())
            }
            else if (binding.code.visibility == EditText.VISIBLE && binding.changePassword.visibility == EditText.INVISIBLE){
                forgetPasswordActivityViewModel.validateCode(binding.code.text.toString(), sharedPreferences.getCode())
            }
            else if (binding.code.visibility == EditText.INVISIBLE && binding.changePassword.visibility == EditText.VISIBLE){
                binding.progressForgetEntity.visibility = ProgressBar.VISIBLE
                forgetPasswordActivityViewModel.changePassword(binding.changePassword.text.toString(), sharedPreferences.getDocumentPath())
            }
        }
    }

    private fun observeSendMessageResult() {
        forgetPasswordActivityViewModel.searchResult.observe(this) { findAccountByPhoneNumberResult ->
            binding.progressForgetEntity.visibility = ProgressBar.INVISIBLE
            when (findAccountByPhoneNumberResult) {
                is InvalidInputPhoneNumber -> {
                    showToast(findAccountByPhoneNumberResult.invalidInput)
                }
                is WrongPhoneNumber -> {
                    dialog(findAccountByPhoneNumberResult.wrongEmail)
                }
                is ServerException -> {
                    showToast(findAccountByPhoneNumberResult.serverError)
                }
                is SuccessPhoneNumberResult -> {
                    val phoneNumber = binding.sendPhone.text.toString().toLiteVersionPhoneNumber()

                    if (permissionCheck && binding.code.visibility == EditText.INVISIBLE) {
                        sendSMS(phoneNumber)
                        binding.code.visibility = EditText.VISIBLE
                        binding.sendPhone.isClickable = false
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            binding.sendPhone.focusable = EditText.NOT_FOCUSABLE
                        }
                        sharedPreferences.saveDocumentPath(findAccountByPhoneNumberResult.userId)
                    } else if (!permissionCheck && binding.code.visibility == EditText.INVISIBLE){
                        dialog("Change SMS permission in settings and restart this app")
                    }
                }
            }
        }

    }

    private fun observeCodeResult() {
        forgetPasswordActivityViewModel.codeResult.observe(this) { sendingCodeResult ->
            when (sendingCodeResult) {
                is WrongCode -> {
                    showToast(sendingCodeResult.wrongCode)
                }
                is InvalidInputCode -> {
                    showToast(sendingCodeResult.invalidInput)
                }
                is SuccessCodeResult -> {
                    binding.code.visibility = EditText.INVISIBLE
                    binding.changePassword.visibility = EditText.VISIBLE
                }
            }
        }
    }

    private fun observeChangingPassword() {
        forgetPasswordActivityViewModel.passwordResult.observe(this) { changingPasswordResult ->
            binding.progressForgetEntity.visibility = ProgressBar.INVISIBLE
            when (changingPasswordResult) {
                is InvalidInputPassword -> {
                    showToast(changingPasswordResult.invalidInput)
                }
                is SuccessPasswordResult -> {
                    showToast(changingPasswordResult.success)
                    sharedPreferences.savePassword(binding.changePassword.text.toString())
                    openActivity(LoginActivity::class.java)
                }
            }
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    private fun sendSMS(phoneNumber: String){
        val rand = (100000..999999).random()
        sharedPreferences.saveSendingCode(rand.toString())
        SmsManager.getDefault().sendTextMessage(binding.sendPhone.text.toString().toLiteVersionPhoneNumber(), null, rand.toString(), null, null)
    }
}