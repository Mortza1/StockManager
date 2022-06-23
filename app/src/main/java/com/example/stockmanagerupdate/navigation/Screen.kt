package com.example.stockmanagerupdate.navigation

sealed class Screen(val route : String) {
    object HomePage : Screen("home_page")
    object AddOrder : Screen("add_order")
    object AddProduct : Screen("add_product")
    object AddCustomer : Screen("add_customer")
    object OrderDetail : Screen("order_detail")
    object ProductDetail : Screen("product_detail")
    object CustomerDetail : Screen("customer_detail")
    object OverView : Screen("over_view")
    object CustomerPage : Screen("customer_page")
}