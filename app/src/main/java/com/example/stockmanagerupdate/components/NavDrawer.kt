package com.example.stockmanagerupdate.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockmanagerupdate.ui.theme.oswald

private val screens = listOf("Transactions","Products", "Customers" , "Analytics" )
@Composable
fun NavDrawer(onCustomerClick : () -> Unit, onTransactionClick : () -> Unit){
    val scope = rememberCoroutineScope()
    Column(Modifier.fillMaxSize()) {
        Card(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(width = 2.dp, color = Color.Black),
            backgroundColor = Color.Cyan
        ) {
            Text(text = "Stock Management",
                Modifier.padding(start = 10.dp, top = 140.dp),
                style = MaterialTheme.typography.h1.copy(fontFamily = oswald, fontSize = 30.sp),
                textAlign = TextAlign.Start)
        }
        for (screen in screens){
            Card(
                Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .border(width = 0.5.dp, color = Color.Black)
                    .clickable {
                        if (screen == "Customers"){
                            onCustomerClick()
                        } else if (screen == "Transactions"){
                            onTransactionClick()
                        }
                    }) {
                Text(
                    text = screen,
                    Modifier.padding(10.dp),
                    style = MaterialTheme.typography.h3.copy(fontSize = 20.sp)
                )
            }
        }
    }
}