package com.example.stockmanagerupdate.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun RowScope.TableCell(
    text: String,
    weight : Float
){
    Text(
        text = text,
        Modifier
            .border(1.dp, Color.Black)
            .weight(weight)
            .padding(8.dp)
    )
}

@Composable
fun Table(){
    val column1Weight = .1f
    val column2Weight = .3f

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        item {
            Row(Modifier.background(Color.Cyan)) {
                TableCell(text = "index", weight = column1Weight )
                TableCell(text = "supplyOrSell", weight = column2Weight )
                TableCell(text = "Date", weight = column2Weight )
                TableCell(text = "Amount", weight = column2Weight )
            }/*
        }
        items(data){
            val (index, supply, date, amount) = it
            Row(Modifier.fillMaxWidth()) {
                TableCell(text = index.toString(), weight = column1Weight)
                TableCell(text = supply, weight = column2Weight)
                TableCell(text = date, weight = column2Weight)
                TableCell(text = amount.toString(), weight = column2Weight)
            }

        }*/
    }

}}

