package com.example.stockmanagerupdate.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockmanagerupdate.database.OrderViewModel
import com.example.stockmanagerupdate.ui.theme.oswald

@Composable
fun OrderDetails(string: String?, viewModel: OrderViewModel) {

    if (string != null) {
        val details by viewModel.orderDetails(string.toInt()).observeAsState()
        val amount = details?.amount
        val type = details?.orderType
        val date = details?.date
        Column(
            Modifier
                .fillMaxSize()
                .padding(15.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "ORDER DETAILS",
                textAlign = TextAlign.Center,
                fontSize = 45.sp,
                fontFamily = oswald
            )}
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = string)

            }
        }


