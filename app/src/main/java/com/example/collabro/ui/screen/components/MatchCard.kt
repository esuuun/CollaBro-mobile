package com.example.collabro.ui.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collabro.ui.theme.Background
import com.example.collabro.ui.theme.CardBackground
import com.example.collabro.R
import com.example.collabro.ui.theme.Primary

@Composable
fun MatchCard(
    title : String,
    desc : String,
    image: Painter,
    modifier: Modifier = Modifier
){
    val isExpanded = remember { mutableStateOf(false) }
    val displayDesc = if (isExpanded.value || desc.length <= 50) {
        desc
    } else {
        desc.take(50) + "...see more"
    }


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        ElevatedCard(
            colors = CardDefaults.elevatedCardColors(
                containerColor = CardBackground // Replace with your desired color
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
//            .size(width = 240.dp, height = 100.dp)
        ) {
            Column() {
                ImageCard(image)

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = displayDesc,
                        fontWeight = FontWeight.Normal ,
                        modifier = Modifier
                                .clickable { isExpanded.value = !isExpanded.value }
                        )
                }
            }
        }
    }
}

@Composable
private fun ImageCard(image: Painter){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = image,
            contentDescription = "card image",
            contentScale = ContentScale.Crop
        )

        Surface(
            shape = CircleShape,
            border = BorderStroke(2.dp, Primary),
            modifier = Modifier.padding(8.dp)
        ) {
        Image(
            painter = painterResource(id = R.drawable.profile_pict),
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .align(Alignment.TopStart),
            contentScale = ContentScale.Crop
        )
        }
    }
}
