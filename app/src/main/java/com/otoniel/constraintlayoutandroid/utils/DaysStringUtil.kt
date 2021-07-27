package com.otoniel.constraintlayoutandroid.utils

class DaysStringUtil {

    companion object {
        fun getDaysString(days: Int) : String {
            var sufix = " days";
            if(days == 1) {
                sufix = " day"
            }
            return days.toString().plus(sufix)
        }
    }
}