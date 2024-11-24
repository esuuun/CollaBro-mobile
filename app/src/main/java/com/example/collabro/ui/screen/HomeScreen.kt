package com.example.collabro.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.collabro.ui.screen.components.ActionBar
import com.example.collabro.ui.screen.components.CardPreview
import com.example.collabro.ui.screen.components.MatchCard
import com.example.collabro.ui.screen.components.NavBar
import com.example.collabro.ui.theme.Background

@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ){
        Scaffold (
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent
        ){
                paddings ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddings)
                    .padding(
                        horizontal = 24.dp,
                        vertical = 24.dp
                    )
            ) {
                ActionBar()
                CardPreview()
//            NavBar()
            }
        }
    }

}