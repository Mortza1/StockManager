package com.example.stockmanagerupdate.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.stockmanagerupdate.database.orderViewModel
import com.example.stockmanagerupdate.screens.*


@Composable
fun Navigation() {
    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = Screen.HomePage.route
    ) {
        composable(Screen.HomePage.route) {
            val viewModel: orderViewModel = hiltViewModel()
            Homepage(viewModel, navController)
        }
        composable(Screen.AddOrder.route) {
            val viewModel: orderViewModel = hiltViewModel()
            addOrder(viewModel, navController)
        }
        composable(Screen.AddCustomer.route) {
            val viewModel: orderViewModel = hiltViewModel()
            addCustomer(viewModel, navController)
        }
        composable(
            "${Screen.OrderDetail.route}/{orderID}"
           )
         {
             val viewModel: orderViewModel = hiltViewModel()
            OrderDetails(it.arguments?.getString("orderID"), viewModel)
        }
        composable(Screen.CustomerPage.route){
            val viewModel: orderViewModel = hiltViewModel()
            Customers(viewModel = viewModel, navController = navController)
        }
        composable(
            "${Screen.CustomerDetail.route}/{customerID}"
        )
        {
            val viewModel: orderViewModel = hiltViewModel()
            CustomerDetails(it.arguments?.getString("customerID"), viewModel)
        }
    }
}
