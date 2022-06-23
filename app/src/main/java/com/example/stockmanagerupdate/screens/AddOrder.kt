package com.example.stockmanagerupdate.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stockmanagerupdate.components.AddOrderButton
import com.example.stockmanagerupdate.components.CustomEditText
import com.example.stockmanagerupdate.database.TransactionsEntity
import com.example.stockmanagerupdate.database.orderViewModel
import com.example.stockmanagerupdate.navigation.Screen
import com.example.stockmanagerupdate.ui.theme.oswald
import kotlinx.coroutines.launch

@Composable
fun addOrder(viewModel: orderViewModel, navController: NavController) {
    var type by rememberSaveable { mutableStateOf("") }
    var date by rememberSaveable { mutableStateOf("") }
    var amount by rememberSaveable { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Box(Modifier.fillMaxSize()) {
        Column(Modifier.padding(horizontal = 5.dp)) {
            Spacer(modifier = Modifier.size(30.dp))
            Text(
                text = "Enter transaction details below",
                Modifier.padding(vertical = 10.dp),
                fontSize = 30.sp,
                fontFamily = oswald
            )
            Spacer(modifier = Modifier.size(30.dp))
            CustomEditText(
                value = type,
                onValueChange = { type = it },
                label = "SupplyOrSell",
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
            CustomEditText(
                value = date,
                onValueChange = { date = it },
                label = "Enter Date",
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
            CustomEditText(
                value = amount,
                onValueChange = { amount = it },
                label = "Enter Amount",
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
            Spacer(modifier = Modifier.size(100.dp))
            AddOrderButton {
                if (type.isNotBlank() && date.isNotBlank() && amount.isNotBlank() ) {
                    viewModel.insertOrder(
                        TransactionsEntity(
                            orderType = type,
                            date = date,
                            amount = amount.toInt()
                        )
                    )
                    scope.launch {
                        navController.navigate(Screen.HomePage.route)
                    }
                }
            }
        }
    }
}
