package com.example.stockmanagerupdate.database

import android.icu.util.CurrencyAmount

data class TransactionsEntityHome(
    val transId : Int = 0,
    val orderType : String = "Supply",
    val date : String,
    val amount : Int,
)
