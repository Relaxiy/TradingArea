package com.example.cars.utils.ext

import android.content.Context
import android.content.Intent
import android.util.Patterns
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.cars.registration.presentation.dialog.ErrorEntryDialog
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.parser.PhoneNumberUnderscoreSlotsParser
import ru.tinkoff.decoro.watchers.MaskFormatWatcher

fun FragmentActivity.openFragment(fragment: Fragment, tag: String, id: Int) {
    supportFragmentManager
        .beginTransaction()
        .replace(id, fragment, tag)
        .addToBackStack(tag)
        .commit()
}

fun FragmentActivity.dialog(message: String) {
    val myDialogFragment = ErrorEntryDialog(message)
    val manager = supportFragmentManager
    myDialogFragment.show(manager, "myDialog")
}

fun String.isEmail(): Boolean{
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun <T> Context.openActivity(activity: Class<T>){
    val intent = Intent(this, activity)
    startActivity(intent)
}

fun EditText.parsePhoneNumber(){
    val slots = PhoneNumberUnderscoreSlotsParser().parseSlots("+375 (__) ___-____");
    val inputMask = MaskImpl.createTerminated(slots);
    val formatWatcher = MaskFormatWatcher(inputMask)
    formatWatcher.installOn(this)
}

fun String.toLiteVersionPhoneNumber(): String {
    val countryCode = this.substring(0, 4)
    val networkCode = this.substring(6, 8)
    val firstPartNumber = this.substring(10, 13)
    val secondPartNumber = this.substring(14)
    return countryCode + networkCode + firstPartNumber + secondPartNumber
}




