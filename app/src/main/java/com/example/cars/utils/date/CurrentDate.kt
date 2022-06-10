package com.example.cars.utils.date

import java.text.SimpleDateFormat
import java.util.*

class CurrentDate {

    companion object{
        private var date = Date()
        private var formater: SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        var currentDate = formater.format(date)
    }
}