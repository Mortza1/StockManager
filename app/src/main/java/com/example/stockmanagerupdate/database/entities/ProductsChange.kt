package com.example.stockmanagerupdate.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductsChange(
    @PrimaryKey(autoGenerate = true)
    val productChangeID : Int = 0,
    val productID : Int,
    val transID : Int,
    val price : Int,
    val quantity : Int
)
