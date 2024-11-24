package com.example.collabro.ui.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ActionBar(
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier.fillMaxWidth(),

    ){
        Location()
    }
}

@Composable
private fun Location(
    modifier: Modifier = Modifier
){
    Column {
        Text(
            "Location",
            color = Color.Gray
        )
        Row {
            Text(
                "Depok, Indonesia"
            )
        }
    }

}