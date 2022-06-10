package com.example.cars.registration.presentation.register.actionSelector

sealed class RegistrationActionSelector{
    object OpenMainActivity : RegistrationActionSelector()

    class ShowInvalidInputDialog: RegistrationActionSelector(){
        companion object{
            const val MESSAGE = "Invalid input!"
        }
    }

    class ShowExistingEmailDialog: RegistrationActionSelector(){
        companion object{
            const val MESSAGE = "This account already register!"
        }
    }
}
