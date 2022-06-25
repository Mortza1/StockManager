package com.example.stockmanagerupdate.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.stockmanagerupdate.components.AddOrderButton
import com.example.stockmanagerupdate.components.CustomEditText
import com.example.stockmanagerupdate.components.productChangeBox
import com.example.stockmanagerupdate.database.entities.TransactionsEntity
import com.example.stockmanagerupdate.database.orderViewModel
import com.example.stockmanagerupdate.navigation.Screen
import com.example.stockmanagerupdate.ui.theme.oswald
import kotlinx.coroutines.launch

@Composable
fun AddOrder(viewModel: orderViewModel, navController: NavController) {

    //all the initializations required by this composable only

    val types = listOf("Supply", "Sell")
    val customers by viewModel.customerNames.observeAsState(listOf())
    var selectedCustomer by rememberSaveable { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var nameSize by remember { mutableStateOf(Size.Zero) }
    var type by rememberSaveable { mutableStateOf("") }
    var date by rememberSaveable { mutableStateOf("") }
    var amount by rememberSaveable { mutableStateOf("") }
    var customerID by rememberSaveable { mutableStateOf("") }
    var productID by rememberSaveable { mutableStateOf("") }
    val scope = rememberCoroutineScope()



    // icon variable is used for the drop down menu

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    //start of the composition
    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .padding(horizontal = 5.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.size(30.dp))
            Text(
                text = "Enter transaction details below",
                Modifier.padding(vertical = 10.dp),
                fontSize = 30.sp,
                fontFamily = oswald
            )
            Spacer(modifier = Modifier.size(30.dp))



            // radio button box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .border(width = 3.dp, color = Color.Black, shape = RoundedCornerShape(10f))
            ) {
                Column {
                    Text(
                        text = "Type of transaction?",
                        Modifier.padding(start = 10.dp, top = 5.dp),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.SemiBold, fontFamily = oswald
                    )
                    types.forEach { item ->
                        Row(Modifier.padding(horizontal = 10.dp, vertical = 3.dp)) {
                            RadioButton(
                                selected = type == item,
                                onClick = { type = item },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.Red
                                )
                            )
                            Text(
                                text = item,
                                Modifier
                                    .padding(start = 16.dp)
                                    .align(Alignment.CenterVertically),
                                fontWeight = FontWeight.Thin, fontFamily = oswald, fontSize = 18.sp
                            )
                        }
                    }
                }
            }




            OutlinedTextField(
                value = selectedCustomer,
                onValueChange = { selectedCustomer = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to
                        // the DropDown the same width
                        nameSize = coordinates.size.toSize()
                    },
                enabled = type == "Sell",
                shape = RoundedCornerShape(20.dp),
                label = { Text("Customer Name") },
                trailingIcon = {
                    Icon(icon, "contentDescription",
                        Modifier.clickable { expanded = !expanded })
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .background(color = Color.Cyan)
                    .width(with(LocalDensity.current) { nameSize.width.toDp() })
            ) {
                customers.forEach { customer ->
                    DropdownMenuItem(onClick = {
                        selectedCustomer = customer
                        selectedCustomer = customer
                        expanded = false
                    }, Modifier.border(width = 1.dp, color = Color.Black)) {
                        Text(text = customer, fontWeight = FontWeight.Light, fontFamily = oswald)
                    }
                }
            }

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
                if (date.isNotBlank() && amount.isNotBlank() && customerID.isNotBlank() && productID.isNotBlank() && type.isNotBlank()) {
                    viewModel.insertOrder(
                        TransactionsEntity(
                            orderType = type,
                            date = date,
                            amount = amount.toInt(),
                            customerID = customerID.toInt()
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
