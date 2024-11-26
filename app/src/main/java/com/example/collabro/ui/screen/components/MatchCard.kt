package com.example.collabro.ui.screen.components

import android.provider.ContactsContract.Profile
import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
import com.example.collabro.ui.theme.Ghost
import com.example.collabro.ui.theme.Primary
import com.example.collabro.ui.theme.Secondary
import kotlinx.coroutines.launch

@Composable
fun MatchCard(
    title : String,
    desc : String,
    image: Painter,
    profile: Painter,
    lookingFor : String,
    index : Int,
    modifier: Modifier = Modifier ,
    onMoveNext: () -> Unit
){
    val isExpanded = remember { mutableStateOf(false) }
    val displayDesc = if (isExpanded.value || desc.length <= 50) {
        desc
    } else {
        desc.take(98) + "...see more"
    }

    val offsetXreject = remember { Animatable(0f) }
    val offsetXaccept = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    val isAccept = remember { mutableStateOf(false) }


        ElevatedCard(
            colors = CardDefaults.elevatedCardColors(
//                containerColor = CardBackground
//                containerColor = if (index == 0) CardBackground else CardBackground.copy(alpha = 0.5f)
                containerColor = CardBackground
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 0.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
//                .offset(y = (index * -16).dp)
//                .graphicsLayer {if(index <= 3) translationY = (index * 12).dp.toPx()}
                .graphicsLayer { translationX = offsetXreject.value }
                .graphicsLayer { translationX = offsetXaccept.value }
//            .size(width = 240.dp, height = 100.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                ImageCard(image, profile)

                    Text(
                        text = title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    LookingFor(lookingFor)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = displayDesc,
                        fontWeight = FontWeight.Normal ,
                        modifier = Modifier
                                .clickable { isExpanded.value = !isExpanded.value }
                        )
                    Spacer(modifier = Modifier.height(6.dp))
                    ActionButton (
                        onReject = {
                            scope.launch {
                                offsetXreject.animateTo(
                                    targetValue = -1000f,
                                    animationSpec = tween(durationMillis = 500) // Adjust animation speed
                                )

                                onMoveNext()
                                offsetXaccept.snapTo(0f)
                            }
                        },

                        onAccept = {
                            scope.launch {
                                offsetXreject.animateTo(
                                    targetValue = 1000f,
                                    animationSpec = tween(durationMillis = 500) // Adjust animation speed
                                )

                                onMoveNext()
                                offsetXaccept.snapTo(0f)
                            }
                        },
                    )


            }
        }
    }



@Composable
private fun ImageCard(image: Painter, profile: Painter){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(306.dp)
        .clip(RoundedCornerShape(14.dp))
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = image,
            contentDescription = "card image",
            contentScale = ContentScale.Crop,

        )

        Surface(
            shape = CircleShape,
            border = BorderStroke(2.dp, Primary),
            modifier = Modifier.padding(8.dp)
        ) {
        Image(
            painter = profile,
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

@Composable
private fun LookingFor(lookingFor: String){
    Row {
        Text(
            text = "Looking For :",
            color = Ghost,
            fontWeight = FontWeight.Medium,
        )
        Spacer(modifier = Modifier.width(2.dp))
        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Primary,
                    shape = RoundedCornerShape(18.dp)
                )
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = lookingFor,
                color = Primary,
                fontWeight = FontWeight.Bold,
            )
        }

    }
}

@Composable
private fun ActionButton(onAccept: () -> Unit, onReject: () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Reject button
        IconButton (
            onClick = { onReject()},
            modifier = Modifier
                .size(52.dp)
                .background(Color.Red.copy(alpha = 0.1f), CircleShape)
        ) {
            Icon(
                Icons.Default.Close,
                contentDescription = "Reject",
                tint = Color.Red
            )
        }

        // Accept button
        IconButton(
            onClick = { onAccept ()}, // Tambahkan 'onClick'
            modifier = Modifier
                .size(52.dp)
                .background(Color.Green.copy(alpha = 0.1f), CircleShape)
        ) {
            Icon(
                Icons.Default.Check,
                contentDescription = "Accept",
                tint = Color.Green
            )
        }
    }
}

