package com.example.stockmanagerupdate.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.stockmanagerupdate.database.entities.ProductsChange
import com.example.stockmanagerupdate.database.entities.TransactionsEntity

data class OrderWithProductsChange(
    @Embedded val orders : TransactionsEntity,
    @Relation(
        parentColumn = "transId",
        entityColumn = "productID"
    )
    val productsChange :List<ProductsChange>
)