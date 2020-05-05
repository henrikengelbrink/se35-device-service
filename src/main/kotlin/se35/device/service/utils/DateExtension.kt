package se35.device.service.utils

import java.util.*

object DateExtension {

    fun dateInYears(inYears: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.YEAR, inYears)
        return calendar.time
    }

}

/*

    Usage:
    val dateIn5Years = DateExtension.dateInYears(5)

 */
