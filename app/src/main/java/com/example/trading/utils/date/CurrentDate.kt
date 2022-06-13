package com.example.trading.utils.date

import java.text.SimpleDateFormat
import java.util.*

class CurrentDate {


    fun getDate(): String {
        val date = Date()
        val formater = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        return formater.format(date)
    }
}