package com.example.stockmanagerupdate.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TransactionsEntity::class, CustomerTable::class], version = 4)
abstract class OrderDatabase : RoomDatabase() {

    abstract val orderDao : OrderDao

}
