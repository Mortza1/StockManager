package com.example.stockmanagerupdate.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stockmanagerupdate.database.orderViewModel
import com.example.stockmanagerupdate.navigation.Screen
import com.example.stockmanagerupdate.ui.theme.oswald
import de.charlex.compose.RevealDirection
import de.charlex.compose.RevealSwipe
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomerCard(
    id: Int,
    name : String,
    navController: NavController,
    viewModel: orderViewModel
) {
    val scope = rememberCoroutineScope()
    RevealSwipe(
        Modifier.fillMaxWidth().height(100.dp).padding(horizontal = 5.dp, vertical = 2.dp),
        onBackgroundEndClick = {
            scope.launch {
                viewModel.deleteCustomer(id)
            }
        },
        shape = RoundedCornerShape(30f),
        backgroundCardEndColor = Color.Red,
        directions = setOf(RevealDirection.EndToStart),
        hiddenContentEnd = {
            Icon(
                modifier = Modifier.padding(horizontal = 25.dp),
                imageVector = Icons.Outlined.Delete,
                contentDescription = null
            )
        }) {
        Card(
            Modifier
                .fillMaxSize()
                .height(100.dp)
                .clickable {
                    scope.launch {
                        navController.navigate("${Screen.CustomerDetail.route}/${id.toString()}")
                    }
                }
                .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(30f)),
            elevation = 30.dp,
            shape = RoundedCornerShape(30f),

            ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Column() {
                    Text(
                        text = "CUSTOMER# $id",
                        Modifier.padding(horizontal = 10.dp).weight(20f),
                        fontSize = 30.sp,
                        fontFamily = oswald,

                    )
                    Text(
                        text = "NAME : $name",
                        Modifier.padding(start = 20.dp, top = 10.dp),
                        fontSize = 20.sp,
                        fontFamily = oswald
                    )
                }


            }

        }
    }
}