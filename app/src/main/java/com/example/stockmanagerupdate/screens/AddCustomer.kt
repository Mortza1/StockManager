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
import com.example.stockmanagerupdate.components.AddCustomerButton
import com.example.stockmanagerupdate.components.CustomEditText
import com.example.stockmanagerupdate.database.entities.CustomerTable
import com.example.stockmanagerupdate.database.OrderViewModel
import com.example.stockmanagerupdate.navigation.Screen
import com.example.stockmanagerupdate.ui.theme.oswald
import kotlinx.coroutines.launch

@Composable
fun addCustomer(viewModel: OrderViewModel, navController: NavController) {
    var name by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Box(Modifier.fillMaxSize()) {
        Column(Modifier.padding(horizontal = 5.dp)) {
            Spacer(modifier = Modifier.size(30.dp))
            Text(
                text = "Enter customer details below",
                Modifier.padding(vertical = 10.dp),
                fontSize = 30.sp,
                fontFamily = oswald
            )
            Spacer(modifier = Modifier.size(30.dp))
            CustomEditText(
                value = name,
                onValueChange = { name = it },
                label = "name",
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )


            Spacer(modifier = Modifier.size(100.dp))
            AddCustomerButton {
                if (name.isNotBlank() ) {
                    viewModel.insertCustomer(
                        CustomerTable(
                            name = name,
                            phone = phone.toInt(),
                            address = address
                        )
                    )
                    scope.launch {
                        navController.navigate(Screen.CustomerPage.route)
                    }
                }
            }
        }
    }
}