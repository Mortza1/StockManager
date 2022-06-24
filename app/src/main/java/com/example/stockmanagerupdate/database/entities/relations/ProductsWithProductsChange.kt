package com.example.stockmanagerupdate.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.stockmanagerupdate.database.entities.ProductsChange
import com.example.stockmanagerupdate.database.entities.ProductsTable

data class ProductsWithProductsChange(
    @Embedded val products : ProductsTable,
    @Relation(
        parentColumn = "productID",
        entityColumn = "productID"
    )
    val productsChange: List<ProductsChange>
)
