package com.example.stockmanagerupdate.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stockmanagerupdate.components.CustomerCard
import com.example.stockmanagerupdate.components.DrawerIcon
import com.example.stockmanagerupdate.components.NavDrawer
import com.example.stockmanagerupdate.components.transactionCard
import com.example.stockmanagerupdate.database.orderViewModel
import com.example.stockmanagerupdate.navigation.Screen
import com.example.stockmanagerupdate.ui.theme.oswald
import kotlinx.coroutines.launch

@Composable
fun Customers(viewModel: orderViewModel, navController : NavController){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val allCustomers by viewModel.allCustomers.observeAsState(listOf())



    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { NavDrawer(onCustomerClick = {
            scope.launch {
                navController.navigate(Screen.CustomerPage.route)
            }
        }, onTransactionClick = {
            scope.launch {
                navController.navigate(Screen.HomePage.route)
            }
        }) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = { scope.launch {
                navController.navigate(Screen.AddCustomer.route)
            } },
                Modifier
                    .size(70.dp)
                    .border(width = 3.dp, color = Color.Black, shape = RoundedCornerShape(100f)), backgroundColor = Color.White, ) {
                Icon(Icons.Filled.Add,"")
            }
        }
    ) {
        Box(
            Modifier
                .fillMaxSize()
        ) {
            Column(Modifier.padding(5.dp)) {
                DrawerIcon(onMenuClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                })
                Box() {
                    Text(
                        text = "CUSTOMERS",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h1.copy(
                            fontFamily = oswald,
                            fontSize = 40.sp
                        )
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                LazyColumn() {
                    this.items(allCustomers) { customer ->
                        CustomerCard(
                            id = customer.customerID,
                            name = customer.name,
                            navController,
                            viewModel
                        )

                    }
                }



            }
        }
    }
}