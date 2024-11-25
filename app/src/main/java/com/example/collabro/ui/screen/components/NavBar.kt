package com.example.collabro.ui.screen.components

import android.service.controls.templates.ControlButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.collabro.R
import com.example.collabro.ui.theme.Background
import com.example.collabro.ui.theme.NavbarBackground
import com.example.collabro.ui.theme.Primary

data class NavBarItem(val imageRes: Int)

val NavbarData = listOf(
    NavBarItem(imageRes = R.drawable.home),
    NavBarItem(imageRes = R.drawable.explore),
    NavBarItem(imageRes = R.drawable.send),
    NavBarItem(imageRes = R.drawable.graph),
    NavBarItem(imageRes = R.drawable.profile),
    )

@Composable
fun NavBar(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    NavbarBackground,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .padding(vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            NavbarData.forEachIndexed { index, item ->
            ControlButton(item,index)
            }
        }
    }
}

@Composable
private fun ControlButton(
    item: NavBarItem,
    index: Int,
    modifier: Modifier = Modifier
){
    val offsetModifier = if (index == 2) {
        Modifier.offset(y = -28.dp) // Apply offset only for the 4th item (index 3)
    } else {
        Modifier // No offset for other items
    }

    val subBackgroundModifier = if (index == 2) {
        Modifier.background(Primary, CircleShape)
    } else {
        Modifier // No offset for other items
    }

    Surface (
        modifier = Modifier
            .size(54.dp)
//            .offset(y = -20.dp)
            .then(offsetModifier)
        , color = Color.Transparent
    ){
        Box (

            modifier = Modifier
                .fillMaxSize()
            , contentAlignment = Alignment.Center
        ){
            IconButton (
                onClick = { },
                modifier = Modifier
                    .size(64.dp)
                    .then(subBackgroundModifier)
            ) {
                Icon(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = "",
                    tint = if (index == 2) Color.White else Color.DarkGray
                )
            }
        }
    }
}