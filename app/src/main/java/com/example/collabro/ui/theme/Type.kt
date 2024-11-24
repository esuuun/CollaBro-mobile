package com.example.collabro.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import com.example.collabro.R


val figtreeFontsFamily = FontFamily(
    Font(R.font.figtree_black, FontWeight.Black),
    Font(R.font.figtree_bold,FontWeight.Bold),
    Font(R.font.figtree_extrabold,FontWeight.ExtraBold),
    Font(R.font.figtree_medium,FontWeight.Medium),
    Font(R.font.figtree_regular,FontWeight.Normal),
    Font(R.font.figtree_semibold,FontWeight.SemiBold),
    Font(R.font.figtree_light,FontWeight.Light),
)

val Typography = Typography(
    bodyLarge = TextStyle(
//        fontFamily = FontFamily.Default,
        fontFamily = figtreeFontsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)
