package com.example.collabro.ui.screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collabro.ui.theme.Ghost
import com.example.collabro.ui.theme.Primary
import com.example.collabro.R

@Composable
fun ActionBar(
    modifier: Modifier = Modifier,
    onLocationClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Location(
            modifier = Modifier.clickable { onLocationClick() }
        )

        Icon(
            painter = painterResource(id = R.drawable.search),
            contentDescription = "Search",
            tint = Primary
        )
    }
}

@Composable
private fun Location(
    modifier: Modifier = Modifier
) {

        Column(
            modifier = Modifier.padding(start = 4.dp)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Location",
                    color = Ghost,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Change location",
                    tint = Ghost
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = "Location",
                    tint = Primary,
                )

                Text(
                    modifier = Modifier.padding(4.dp,0.dp,0.dp,0.dp),
                    text = "Depok,",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )
                Text(
                    text = " Indonesia",
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                )
        }
    }
}