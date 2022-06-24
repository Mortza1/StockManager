package com.example.stockmanagerupdate.database

import androidx.lifecycle.*
import com.example.stockmanagerupdate.database.entities.CustomerTable
import com.example.stockmanagerupdate.database.entities.CustomerTableMinimal
import com.example.stockmanagerupdate.database.entities.TransactionsEntity
import com.example.stockmanagerupdate.database.entities.TransactionsEntityMinimal
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class orderViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val allOrders : LiveData<List<TransactionsEntityMinimal>> = repository.allOrders.asLiveData()
    val allCustomersHome : LiveData<List<CustomerTableMinimal>> = repository.allCustomers.asLiveData()
    val customerNames : LiveData<List<String>> = repository.customerNames.asLiveData()
    val productNames : LiveData<List<String>> = repository.productNames.asLiveData()

    fun insertOrder(order : TransactionsEntity){
        repository.insertTransaction(order)
    }
    fun insertCustomer(customer : CustomerTable){
        repository.insertCustomer(customer)
    }
    fun orderDetails(orderID : Int) :LiveData<TransactionsEntity>{
        return repository.transactionDetails(orderID).asLiveData()
    }
    fun deleteOrder(id : Int, name : String){
        repository.deleteTransaction(id)
    }
    fun deleteCustomer(id : Int){
        repository.deleteCustomer(id)
    }

}



