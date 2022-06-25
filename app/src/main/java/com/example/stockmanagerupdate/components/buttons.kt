package com.example.stockmanagerupdate.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockmanagerupdate.ui.theme.oswald

@Composable
fun AddOrderButton(onButtonClick : () -> Unit){
    Button(onClick = onButtonClick,
        Modifier.fillMaxWidth().padding(10.dp)
            .shadow(elevation = 3.dp, shape = RoundedCornerShape(20.dp))
            .height(75.dp)) {
        Text(text = "Add Transaction",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.button.copy(fontFamily = oswald, fontSize = 15.sp ))
    }
}

@Composable
fun AddCustomerButton(onButtonClick : () -> Unit){
    Button(onClick = onButtonClick,
        Modifier.fillMaxWidth()
            .shadow(elevation = 3.dp, shape = RoundedCornerShape(20.dp))
            .height(75.dp)) {
        Text(text = "Add Customer",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.button.copy(fontFamily = oswald, fontSize = 15.sp ))
    }
}