package com.example.stockmanagerupdate.database


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CustomerTable(
    @PrimaryKey(autoGenerate = true)
    val customerID : Int = 0,
    val name : String,
)
