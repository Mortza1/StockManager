package com.example.stockmanagerupdate.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.stockmanagerupdate.database.entities.*
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

    //all the daos for the transactions screen
    @Transaction
    @Query("SELECT transId, orderType, date, amount FROM TransactionsEntity ORDER BY transId DESC")
    fun homePageTransactions(): Flow<List<TransactionsEntityMinimal>>

    @Transaction
    @Query("SELECT * FROM TransactionsEntity where transId = :orderID")
    fun transactionsDetails(orderID: Int): Flow<TransactionsEntity>

    @Transaction
    @Insert()
    fun insertTransaction(transaction: TransactionsEntity)

    @Transaction
    @Query("DELETE FROM TransactionsEntity WHERE transId = :userId")
    fun deleteByTransId(userId: Int)





    //all the daos for ProductChange and product
    @Transaction
    @Insert
    fun insertProductChange(productsChange: ProductsChange)

    @Transaction
    @Insert
    fun insertProduct(product : ProductsTable)

    @Transaction
    @Query("DELETE FROM ProductsTable WHERE productID = :productID")
    fun deleteByProductID(productID: Int)

    @Transaction
    @Query("SELECT * FROM ProductsTable ORDER BY productID DESC")
    fun homePageProducts(): Flow<List<ProductsTable>>

    @Transaction
    @Query("select name from ProductsTable order by productID DESC")
    fun productNames(): Flow<List<String>>

    @Transaction
    @Query("SELECT * FROM ProductsTable where productID = :productID")
    fun productDetails(productID: Int): Flow<ProductsTable>

    @Transaction
    @Query("SELECT * FROM ProductsChange where productID = :productID")
    fun productChangeDetails(productID: Int): Flow<ProductsChange>







    //all the daos for customers
    @Transaction
    @Insert()
    fun insertCustomer(customer: CustomerTable)

    @Transaction
    @Query("SELECT customerID, name FROM CustomerTable ORDER BY customerID ASC")
    fun customerPage(): Flow<List<CustomerTableMinimal>>

    @Transaction
    @Query("select name from CustomerTable order by customerID DESC")
    fun customerNames(): Flow<List<String>>

    @Transaction
    @Query("DELETE FROM CustomerTable WHERE customerID = :id")
    fun deleteByCustomerId(id: Int)
}
