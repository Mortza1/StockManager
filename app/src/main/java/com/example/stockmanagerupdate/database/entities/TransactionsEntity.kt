package com.example.stockmanagerupdate.database.entities

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
)

data class TransactionsEntityMinimal(
    val transId : Int = 0,
    val orderType : String = "Supply",
    val date : String,
    val amount : Int,
)

