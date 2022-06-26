package com.example.stockmanagerupdate.database.entities


import android.provider.ContactsContract
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CustomerTable(
    @PrimaryKey(autoGenerate = true)
    val customerID : Int = 0,
    val name : String,
    val phone : String,
    val address : String
)


data class CustomerTableMinimal(
    val customerID: Int,
    val name : String
)
