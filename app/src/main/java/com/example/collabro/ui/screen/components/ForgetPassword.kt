package com.example.collabro.ui.screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.collabro.ui.theme.Primary

@Composable
fun ForgetPassword(){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd
    ) {
        TextButton(onClick = {}) {
            Text(
                "Forget Password",
                color = Color.Green,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        }
    }
}
