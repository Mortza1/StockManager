package com.example.stockmanagerupdate.database

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class orderViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val allOrders : LiveData<List<TransactionsEntityHome>> = repository.allOrders.asLiveData()
    val allCustomers : LiveData<List<CustomerTable>> = repository.allCustomers.asLiveData()

    fun insertOrder(order : TransactionsEntity){
        repository.insertOrder(order)
    }
    fun insertCustomer(customer : CustomerTable){
        repository.insertCustomer(customer)
    }
    fun orderDetails(orderID : Int) :LiveData<TransactionsEntity>{
        return repository.orderDetails(orderID).asLiveData()
    }
    fun deleteOrder(id : Int, name : String){
        repository.deleteOrder(id)
        repository.deleteOrderId(name)
    }
    fun deleteCustomer(id : Int){
        repository.deleteCustomer(id)
    }

}



