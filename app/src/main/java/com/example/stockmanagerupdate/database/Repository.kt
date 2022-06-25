package com.example.stockmanagerupdate.database

import com.example.stockmanagerupdate.database.entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val orderDao: OrderDao) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allOrders: Flow<List<TransactionsEntityMinimal>> = orderDao.homePageTransactions()
    val allCustomers: Flow<List<CustomerTableMinimal>> = orderDao.customerPage()
    val allProducts: Flow<List<ProductsTable>> = orderDao.homePageProducts()
    val customerNames: Flow<List<String>> = orderDao.customerNames()
    val productNames: Flow<List<String>> = orderDao.productNames()


    // all functions for transactions

    fun insertTransaction(transaction: TransactionsEntity) {
        coroutineScope.launch(Dispatchers.IO) {
            orderDao.insertTransaction(transaction)
        }
    }
    fun deleteTransaction(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            orderDao.deleteByTransId(id)
        }
    }
    fun transactionDetails(orderID: Int): Flow<TransactionsEntity> {
        return orderDao.transactionsDetails(orderID)
    }





    //all the functions for products

    fun insertProductChange(productsChange: ProductsChange) {
        coroutineScope.launch(Dispatchers.IO) {
            orderDao.insertProductChange(productsChange)
        }
    }
    fun insertProduct(product: ProductsTable) {
        coroutineScope.launch(Dispatchers.IO) {
            orderDao.insertProduct(product)
        }
    }
    //fun deleteProduct(id: Int) {
      //  coroutineScope.launch(Dispatchers.IO) {
        //    orderDao.deleteByProductID(id)
        //}
    //}
    fun productChangeDetails(id: Int): Flow<ProductsChange> {
        return orderDao.productChangeDetails(id)
    }



    // all the functions for customers

    fun insertCustomer(customer: CustomerTable) {
        coroutineScope.launch(Dispatchers.IO) {
            orderDao.insertCustomer(customer)
        }
    }
    fun deleteCustomer(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            orderDao.deleteByCustomerId(id)
        }
    }
}