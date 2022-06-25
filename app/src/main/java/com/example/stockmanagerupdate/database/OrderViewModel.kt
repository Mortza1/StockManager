package com.example.stockmanagerupdate.database

import androidx.lifecycle.*
import com.example.stockmanagerupdate.database.entities.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val allOrders : LiveData<List<TransactionsEntityMinimal>> = repository.allOrders.asLiveData()
    val allCustomersHome : LiveData<List<CustomerTableMinimal>> = repository.allCustomers.asLiveData()
    val customerNames : LiveData<List<String>> = repository.customerNames.asLiveData()
    val productNames : LiveData<List<String>> = repository.productNames.asLiveData()
    val allTransID : LiveData<List<Int>> = repository.allTransId.asLiveData()


    fun insertOrder(order : TransactionsEntity){
        repository.insertTransaction(order)
    }
    fun insertCustomer(customer : CustomerTable){
        repository.insertCustomer(customer)
    }
    fun insertProductChange(productsChange: ProductsChange){
        repository.insertProductChange(productsChange)
    }
    fun orderDetails(orderID : Int) :LiveData<TransactionsEntity>{
        return repository.transactionDetails(orderID).asLiveData()
    }
    fun findProdID(name : String) : LiveData<Int>{
        return repository.findProdID(name).asLiveData()
    }
    fun deleteOrder(id : Int, name : String){
        repository.deleteTransaction(id)
    }
    fun deleteCustomer(id : Int){
        repository.deleteCustomer(id)
    }

}



