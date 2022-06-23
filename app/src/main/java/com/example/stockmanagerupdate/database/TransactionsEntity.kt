package com.example.stockmanagerupdate.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TransactionsEntity(
    @PrimaryKey(autoGenerate = true)
    val transId : Int = 0,
    val orderType : String = "Supply",
    val date : String,
    val amount : Int,
    val customerID : Int,
    val products : String
)
