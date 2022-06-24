package com.example.stockmanagerupdate.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.stockmanagerupdate.database.entities.CustomerTable
import com.example.stockmanagerupdate.database.entities.TransactionsEntity

@Database(entities = [TransactionsEntity::class, CustomerTable::class], version = 5)
abstract class OrderDatabase : RoomDatabase() {

    abstract val orderDao : OrderDao

}
