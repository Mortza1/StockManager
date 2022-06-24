package com.example.stockmanagerupdate.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.stockmanagerupdate.database.entities.CustomerTable
import com.example.stockmanagerupdate.database.entities.TransactionsEntity

data class CustomerWithOrders (
    @Embedded val customers : CustomerTable,
    @Relation(
        parentColumn = "customerID",
        entityColumn = "customerID"
    )
    val orders : List<TransactionsEntity>
        )