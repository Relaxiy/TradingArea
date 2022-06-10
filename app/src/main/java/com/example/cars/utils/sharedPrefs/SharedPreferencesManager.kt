package com.example.cars.utils.sharedPrefs

interface SharedPreferencesManager {

    fun saveSign(value: Boolean)

    fun getSign() : Boolean

    fun saveDocumentPath(documentPath: String)

    fun getDocumentPath() : String

    fun saveSendingCode(code: String)

    fun getCode() : String

    fun saveEmail(email: String)

    fun getEmail() : String

    fun savePassword(password: String)

    fun getPassword() : String
}