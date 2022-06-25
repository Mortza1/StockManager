package com.example.stockmanagerupdate.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stockmanagerupdate.database.OrderViewModel
import com.example.stockmanagerupdate.screens.*


@Composable
fun Navigation() {
    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = Screen.HomePage.route
    ) {
        composable(Screen.HomePage.route) {
            val viewModel: OrderViewModel = hiltViewModel()
            Homepage(viewModel, navController)
        }
        composable(Screen.AddOrder.route) {
            val viewModel: OrderViewModel = hiltViewModel()
            AddOrder(viewModel, navController)
        }
        composable(Screen.AddCustomer.route) {
            val viewModel: OrderViewModel = hiltViewModel()
            addCustomer(viewModel, navController)
        }
        composable(
            "${Screen.OrderDetail.route}/{orderID}"
           )
         {
             val viewModel: OrderViewModel = hiltViewModel()
            OrderDetails(it.arguments?.getString("orderID"), viewModel)
        }
        composable(Screen.CustomerPage.route){
            val viewModel: OrderViewModel = hiltViewModel()
            Customers(viewModel = viewModel, navController = navController)
        }
        composable(
            "${Screen.CustomerDetail.route}/{customerID}"
        )
        {
            val viewModel: OrderViewModel = hiltViewModel()
            CustomerDetails(it.arguments?.getString("customerID"), viewModel)
        }
    }
}
