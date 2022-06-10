package com.example.cars.utils.sharedPrefs

import android.content.Context
import javax.inject.Inject

class SharedPreferencesManagerImpl @Inject constructor(context: Context) :
    SharedPreferencesManager {
    companion object {
        private const val PREFS_NAME_IS_SIGN = "login_prefs"
        private const val PREFS_NAME_EMAIL = "login_prefs_email"
        private const val PREFS_NAME_PASSWORD = "login_prefs_password"
        private const val PREFS_DOCUMENT_PATH = "document_path"
        private const val PREFS_CODE_PATH = "code_path"
        private const val PREFS_KEY_SIGN = "sign"
        private const val PREFS_KEY_EMAIL = "email"
        private const val PREFS_KEY_PASSWORD = "password"
        private const val PREFS_KEY_DOCUMENT_PATH = "path"
        private const val PREFS_KEY_CODE = "code"
        private const val BOOLEAN_DEFAULT_VALUE = false
        private const val STRING_DEFAULT_VALUE = ""
    }

    private val prefs by lazy { context.getSharedPreferences(PREFS_NAME_IS_SIGN, Context.MODE_PRIVATE) }
    private val prefsEmail by lazy { context.getSharedPreferences(PREFS_NAME_EMAIL, Context.MODE_PRIVATE) }
    private val prefsPassword by lazy { context.getSharedPreferences(PREFS_NAME_PASSWORD, Context.MODE_PRIVATE) }
    private val prefsDocumentPath by lazy { context.getSharedPreferences(PREFS_DOCUMENT_PATH, Context.MODE_PRIVATE) }
    private val prefsCode by lazy { context.getSharedPreferences(PREFS_CODE_PATH, Context.MODE_PRIVATE) }

    override fun saveSign(value: Boolean) {
        prefs.edit()
            .putBoolean(PREFS_KEY_SIGN, value)
            .apply()
    }

    override fun getSign(): Boolean {
        return prefs.getBoolean(PREFS_KEY_SIGN, BOOLEAN_DEFAULT_VALUE)
    }

    override fun saveDocumentPath(documentPath: String) {
        prefsDocumentPath.edit()
            .putString(PREFS_KEY_DOCUMENT_PATH, documentPath)
            .apply()
    }

    override fun getDocumentPath(): String {
        val documentPath = prefsDocumentPath.getString(PREFS_KEY_DOCUMENT_PATH, STRING_DEFAULT_VALUE)
        return documentPath ?: STRING_DEFAULT_VALUE
    }

    override fun saveSendingCode(code: String) {
        prefsCode.edit()
            .putString(PREFS_KEY_CODE, code)
            .apply()
    }

    override fun getCode(): String {
        val code = prefsCode.getString(PREFS_KEY_CODE, STRING_DEFAULT_VALUE)
        return code ?: STRING_DEFAULT_VALUE
    }

    override fun saveEmail(email: String) {
        prefsEmail.edit()
            .putString(PREFS_KEY_EMAIL, email)
            .apply()
    }

    override fun getEmail(): String {
        val email = prefsEmail.getString(PREFS_KEY_EMAIL, STRING_DEFAULT_VALUE)
        return email ?: STRING_DEFAULT_VALUE
    }

    override fun savePassword(password: String) {
        prefsPassword.edit()
            .putString(PREFS_KEY_PASSWORD, password)
            .apply()
    }

    override fun getPassword(): String {
        val password = prefsPassword.getString(PREFS_KEY_PASSWORD, STRING_DEFAULT_VALUE)
        return password ?: STRING_DEFAULT_VALUE
    }

}