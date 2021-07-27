package com.otoniel.constraintlayoutandroid.model

import com.otoniel.constraintlayoutandroid.utils.CurrencyFormat
import com.otoniel.constraintlayoutandroid.utils.DaysStringUtil
import java.io.Serializable
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class Model(var city: String,var image: String,  var days: Int,
            var price: BigDecimal
) :Serializable {

    fun getDaysString() : String {
        return DaysStringUtil.getDaysString(days)
    }

    fun getFormattedPrice(): String {
        return CurrencyFormat.getMoney(price)
    }

    fun getDatePeriod() : String {
        var startDate = Calendar.getInstance()
        var finishDate = Calendar.getInstance()
        finishDate.add(Calendar.DATE, days)

        var dateFormat = SimpleDateFormat("dd/MM")
        var starDateString = dateFormat.format(startDate.time)
        var finishDateString = dateFormat.format(finishDate.time)
        return starDateString +
                " - " + finishDateString +
                " de " + finishDate.get(Calendar.YEAR)
    }
}
