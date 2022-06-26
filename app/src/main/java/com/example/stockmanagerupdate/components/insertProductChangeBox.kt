package com.example.stockmanagerupdate.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.stockmanagerupdate.database.OrderViewModel
import com.example.stockmanagerupdate.database.entities.ProductsChange
import com.example.stockmanagerupdate.ui.theme.oswald
import kotlinx.coroutines.launch

@Composable
fun productChangeBox(
    viewModel: OrderViewModel
) {

    //necessary Initializations
    val productNames by viewModel.productNames.observeAsState(listOf())
    var selectedProduct by rememberSaveable { mutableStateOf("") }
    var price by rememberSaveable { mutableStateOf("") }
    var quantity by rememberSaveable { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var nameSize by remember { mutableStateOf(Size.Zero) }
    val scope = rememberCoroutineScope()
    val productID by viewModel.findProdID(selectedProduct).observeAsState(0)
    val allTransID by viewModel.allTransID.observeAsState(listOf())


    //for the drop down menu box
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown




    Box(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .border(width = 3.dp, color = Color.Black, shape = RoundedCornerShape(15f))
    ) {
        Column(Modifier.padding(5.dp)) {
            Text(
                text = "Enter Product Info.",
                Modifier.padding(start = 5.dp),
                fontWeight = FontWeight.Bold,
                fontFamily = oswald,
                fontSize = 25.sp
            )


            //start of drop down menu edittext
            OutlinedTextField(
                value = selectedProduct,
                onValueChange = { selectedProduct = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to
                        // the DropDown the same width
                        nameSize = coordinates.size.toSize()
                    },
                shape = RoundedCornerShape(20.dp),
                label = { Text("Product Name") },
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
                productNames.forEach { product ->
                    DropdownMenuItem(onClick = {
                        selectedProduct = product
                        expanded = false
                    }, Modifier.border(width = 1.dp, color = Color.Black)) {
                        Text(text = product, fontWeight = FontWeight.Light, fontFamily = oswald)
                    }
                }
            }


            // price Edittext
            OutlinedTextField(
                value = price, onValueChange = { price = it },
                Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                maxLines = 1,
                label = { Text(text = "Enter the price") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )

            //quantity edittext
            OutlinedTextField(
                value = quantity, onValueChange = { quantity = it },
                Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                maxLines = 1,
                label = { Text(text = "Enter quantity") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
            )
            Button(onClick = {
                if(selectedProduct.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()){
                             scope.launch {
                                 viewModel.insertProductChange(
                                     ProductsChange(
                                         productID = productID,
                                         transID = allTransID[0]+1,
                                         price = price.toInt(),
                                         quantity = quantity.toInt()
                                     )
                                 )
                             }}
            },
                Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .height(50.dp),
            shape = RoundedCornerShape(30f)) {
                Text(text = "Save Product Data")
            }

        }
    }
}