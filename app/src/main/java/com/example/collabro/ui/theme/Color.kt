package com.example.collabro.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

var Primary = Color(0,170,91)
var Secondary = Color(9, 222, 122)
//var Background = Color(215, 255, 236)
var CardBackground = Color.White
var Ghost = Color.Gray

val Background = Brush.linearGradient(
    colors = listOf(
        Color(0xFFEEFFF6), // Start color
        Color(0xFFB2FFDA)  // End color
    )
)