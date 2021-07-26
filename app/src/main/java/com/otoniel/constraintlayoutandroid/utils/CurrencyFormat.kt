package com.otoniel.constraintlayoutandroid.utils

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class CurrencyFormat {
    companion object {
        private val DEFAULT_MONEY: String = "BRL"
        fun getMoney(money: BigDecimal) : String {
            val format: NumberFormat = NumberFormat.getCurrencyInstance()
            format.maximumFractionDigits = 2
            format.currency = Currency.getInstance(DEFAULT_MONEY)
            return format.format(money);
        }
    }
}