package com.example.stockmanagerupdate.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AddProductSign(onAddClick : () -> Unit, onSubtractClick : () -> Unit) {
    Box(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()) {
        Row() {
            Button(
                onClick = onSubtractClick,
                Modifier.weight(20f),
                shape = RoundedCornerShape(100f),
                border = BorderStroke(width = 2.dp, color = Color.Black),
            ) {
                Icon(Icons.Filled.Clear, "")
            }
            Divider(Modifier.weight(60f).align(Alignment.CenterVertically),color = Color.Black, thickness = 3.dp)
            Button(
                onClick = onAddClick,
                shape = RoundedCornerShape(100f),
                border = BorderStroke(width = 2.dp, color = Color.Black),
            ) {
                Icon(Icons.Filled.Add, "")
            }
        }
    }
}