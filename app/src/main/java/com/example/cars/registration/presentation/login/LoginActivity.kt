package com.example.cars.registration.presentation.login

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.CarApplication
import com.example.cars.app.presentation.MainActivity
import com.example.cars.app.presentation.personalPage.UserSharedViewModel
import com.example.cars.databinding.ActivityLoginBinding
import com.example.cars.registration.presentation.register.RegisterActivity
import com.example.cars.registration.presentation.login.actionSelector.AccountSearchResult.*
import com.example.cars.registration.presentation.login.resetPassword.ForgetPasswordActivity
import com.example.cars.utils.sharedPrefs.SharedPreferencesManager
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.openActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    private val loginActivityViewModel: LoginActivityViewModel by viewModels {
        CarApplication.appComponentWithSharedViewModel.viewModelsFactory()
    }

    private lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var sharedPreferences: SharedPreferencesManager

    @Inject
    lateinit var userSharedViewModel: UserSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CarApplication.initAppComponentWithSharedViewModel(this, this)
        CarApplication.appComponentWithSharedViewModel.inject(this)

        if (sharedPreferences.getSign()){
            binding.inputLoginEmail.setText(sharedPreferences.getEmail())
            binding.inputLoginPassword.setText(sharedPreferences.getPassword())
        }
    }

    override fun onStart() {
        super.onStart()
        forgotPassword()
        login()
        toRegister()
    }

    private fun forgotPassword(){
        binding.forgotPassword.setOnClickListener {
            openActivity(ForgetPasswordActivity::class.java)
        }
    }

    private fun login() {
        loginButton.setOnClickListener {
            binding.progressLogin.visibility = ProgressBar.VISIBLE
            loginActivityViewModel.signIn(
                binding.inputLoginEmail.text.toString(),
                binding.inputLoginPassword.text.toString()
            )
        }

        loginActivityViewModel.searchResult.observe(this) { accountSearchResult ->
            binding.progressLogin.visibility = ProgressBar.INVISIBLE
            when (accountSearchResult) {
                is WrongResult -> dialog(WrongResult().error)
                is InvalidInput -> dialog(InvalidInput().invalidInput)
                is SuccessResult -> {
                    userSharedViewModel.shareAccountIntoPersonalPage(
                        accountSearchResult.accountResponse.id,
                        accountSearchResult.accountResponse.username,
                        accountSearchResult.accountResponse.email,
                        accountSearchResult.accountResponse.phoneNumber,
                        accountSearchResult.accountResponse.birthday,
                        accountSearchResult.accountResponse.password,
                        accountSearchResult.accountResponse.createdAt
                    )
                    sharedPreferences.saveDocumentPath(accountSearchResult.accountResponse.id)
                    sharedPreferences.saveSign( true)
                    sharedPreferences.saveEmail(binding.inputLoginEmail.text.toString())
                    sharedPreferences.savePassword(binding.inputLoginPassword.text.toString())
                    openActivity(MainActivity::class.java)
                }
            }
        }
    }

    private fun toRegister() {
        toRegister.setOnClickListener {
            openActivity(RegisterActivity::class.java)
        }
    }

}