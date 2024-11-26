package com.example.collabro.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.foundation.AnchorType
import androidx.wear.compose.foundation.CurvedAlignment
import androidx.wear.compose.foundation.CurvedLayout
import androidx.wear.compose.foundation.CurvedTextStyle
import androidx.wear.compose.foundation.curvedRow
import androidx.wear.compose.material.curvedText
import com.example.collabro.R
import com.example.collabro.ui.screen.components.NavBar
import com.example.collabro.ui.theme.Primary

@Composable
fun NotificationScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp, 30.dp),
            contentAlignment = Alignment.Center
        ){
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Notifications", fontWeight =  FontWeight.Bold)

                Spacer(modifier = Modifier.width(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.solar_settings_outline),
                    contentDescription = "image",
                    Modifier.size(30.dp, 30.dp)
                )
            }
        }
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent
        ) { paddings ->
            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddings)
                    .padding(
                        horizontal = 24.dp,
                        vertical = 24.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement =  Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddings),
                    contentAlignment = Alignment.Center
                ) {
                    CurvedLayout(
                        anchor = 200f,
                        anchorType = AnchorType.Center,
                        modifier = Modifier.size(150.dp),
                        radialAlignment = CurvedAlignment.Radial.Center
                    ) {
                        curvedRow(
                        ) {
                            curvedText(
                                text = "You are All Catch Up",
                                style = CurvedTextStyle(
                                    fontSize = 14.sp,
                                    color = Primary,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            )
                        }
                    }
                }
                Text("Halo")
            }
        }
        Box(
            contentAlignment = Alignment.BottomCenter
        ) {
            NavBar()
        }
    }
}