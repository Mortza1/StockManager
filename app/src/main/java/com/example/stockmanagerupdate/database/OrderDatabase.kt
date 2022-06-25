package com.example.stockmanagerupdate.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.stockmanagerupdate.database.entities.CustomerTable
import com.example.stockmanagerupdate.database.entities.ProductsChange
import com.example.stockmanagerupdate.database.entities.ProductsTable
import com.example.stockmanagerupdate.database.entities.TransactionsEntity

@Database(entities = [TransactionsEntity::class, CustomerTable::class, ProductsChange::class, ProductsTable::class], version = 6)
abstract class OrderDatabase : RoomDatabase() {

    abstract val orderDao : OrderDao

}
