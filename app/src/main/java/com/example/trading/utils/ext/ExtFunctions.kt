package com.example.trading.utils.ext

import android.content.Context
import android.content.Intent
import android.util.Patterns
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.trading.registration.presentation.dialog.ErrorEntryDialog
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.suspendCancellableCoroutine
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.parser.PhoneNumberUnderscoreSlotsParser
import ru.tinkoff.decoro.watchers.MaskFormatWatcher
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

fun <T> Context.openActivity(activity: Class<T>) {
    val intent = Intent(this, activity)
    startActivity(intent)
}

fun FragmentActivity.openFragment(fragment: Fragment, tag: String, id: Int) {
    supportFragmentManager
        .beginTransaction()
        .replace(id, fragment, tag)
        .commit()
}

suspend fun <T> Task<T>.await(): T {
    if (isComplete) {
        val e = exception
        return if (e == null) {
            if (isCanceled) {
                throw CancellationException(
                    "Task $this was cancelled normally."
                )
            } else {
                result
            }
        } else {
            throw e
        }
    }

    return suspendCancellableCoroutine { cont ->
        addOnCompleteListener {
            val e = exception
            if (e == null) {
                if (isCanceled) cont.cancel()
                else cont.resume(result)
            } else {
                cont.resumeWithException(e)
            }
        }
    }
}

fun String.isEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun FragmentActivity.dialog(message: String) {
    val myDialogFragment = ErrorEntryDialog(message)
    val manager = supportFragmentManager
    myDialogFragment.show(manager, "myDialog")
}

fun EditText.parsePhoneNumber() {
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

fun String.toDate(): String {
    return this.substring(0, 10)
}





