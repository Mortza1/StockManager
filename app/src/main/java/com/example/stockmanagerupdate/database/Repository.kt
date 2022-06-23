package com.example.stockmanagerupdate.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val orderDao: OrderDao) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allOrders: Flow<List<TransactionsEntityHome>> = orderDao.homePageOrders()
    val allCustomers: Flow<List<CustomerTable>> = orderDao.customerPage()


    fun insertOrder(order: TransactionsEntity) {
        coroutineScope.launch(Dispatchers.IO) {
            orderDao.insertOrder(order)
        }
    }
    fun insertCustomer(customer: CustomerTable) {
        coroutineScope.launch(Dispatchers.IO) {
            orderDao.insertCustomer(customer)
        }
    }
    fun deleteOrder(id : Int){
        coroutineScope.launch(Dispatchers.IO) {
            orderDao.deleteByTransId(id)
        }
    }
    fun deleteOrderId(name : String){
        coroutineScope.launch(Dispatchers.IO) {
            orderDao.deleteByTransIdNum(name)
        }
    }
    fun deleteCustomer(id : Int){
        coroutineScope.launch(Dispatchers.IO) {
            orderDao.deleteByCustomerId(id)
        }
    }

    fun orderDetails(orderID: Int) : Flow<TransactionsEntity> {
        return orderDao.orderDetails(orderID)
    }
}