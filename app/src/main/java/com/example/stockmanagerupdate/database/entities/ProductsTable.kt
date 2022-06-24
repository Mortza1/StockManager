package com.example.stockmanagerupdate.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductsTable(
    @PrimaryKey(autoGenerate = true)
    val productID : Int = 0,
    val name : String
)
