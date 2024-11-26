package com.example.collabro.ui.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Or(){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(100.dp,1.dp).background(Color.Gray, shape = RectangleShape))
            Spacer(modifier = Modifier.width(20.dp))
            Text("OR", color = Color.Gray, fontSize = 12.sp, fontWeight = FontWeight.Bold, lineHeight = 30.sp)
            Spacer(modifier = Modifier.width(20.dp))
            Box(modifier = Modifier.size(100.dp,1.dp).background(Color.Gray, shape = RectangleShape))
        }
    }
}