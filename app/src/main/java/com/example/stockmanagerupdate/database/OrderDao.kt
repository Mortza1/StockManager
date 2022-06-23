package com.example.stockmanagerupdate.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao{

    @Transaction
    @Query("SELECT transId, orderType, date, amount FROM TransactionsEntity ORDER BY transId DESC")
    fun homePageOrders() : Flow<List<TransactionsEntityHome>>

    @Transaction
    @Query("SELECT * FROM TransactionsEntity where transId = :orderID")
    fun orderDetails(orderID : Int) : Flow<TransactionsEntity>

    @Transaction
    @Insert()
    fun insertOrder(order : TransactionsEntity)

    @Transaction
    @Query("DELETE FROM TransactionsEntity WHERE transId = :userId")
    fun deleteByTransId(userId: Int)
    @Transaction
    @Query("DELETE FROM sqlite_sequence WHERE name = :name")
    fun deleteByTransIdNum(name : String)

    @Transaction
    @Insert()
    fun insertCustomer(customer : CustomerTable)

    @Transaction
    @Query("SELECT customerID, name FROM CustomerTable ORDER BY customerID ASC")
    fun customerPage() : Flow<List<CustomerTable>>

    @Transaction
    @Query("DELETE FROM CustomerTable WHERE customerID = :id")
    fun deleteByCustomerId(id: Int)
}
