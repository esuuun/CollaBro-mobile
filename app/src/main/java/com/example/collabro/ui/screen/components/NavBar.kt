package com.example.collabro.ui.screen.components

import android.service.controls.templates.ControlButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun NavBar(
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ){
        ControlButton()
    }
}

@Composable
private fun ControlButton(
    modifier: Modifier = Modifier
){
    Surface (
        modifier = Modifier
            .size(48.dp)
    ){
        Box (
            modifier = Modifier.fillMaxSize()
        ){
        }
    }
}