package com.example.collabro.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.collabro.R

@Composable
fun Google() {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Button(
            onClick = {},
            Modifier.fillMaxWidth().padding(horizontal = 20.dp)
                .border(2.dp, Color.Black, RoundedCornerShape(10.dp)).height(40.dp),
            colors = ButtonDefaults.buttonColors(Color.White),
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "image",
                    Modifier.size(30.dp, 30.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Continue With Google",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
}