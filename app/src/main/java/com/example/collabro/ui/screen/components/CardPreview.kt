package com.example.collabro.ui.screen.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collabro.R
import com.example.collabro.ui.theme.CardBackground
import kotlinx.coroutines.launch

data class MatchItem(val title: String, val desc: String, val imageRes: Int, val profileImage: Int)

val data = listOf(
    MatchItem(
        title = "Lomba Innoverse",
        desc = "Hi ! Kami adalah sebuah tim dari Universitas Indonesia, sedang mencari UI/UX designers untuk lomba balap karung Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce sodales gravida risus, vitae ultricies mi placerat et. Integer eu dapibus dolor. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aenean fermentum vehicula egestas. Sed id turpis quis lectus molestie pharetra. Nullam pulvinar erat eget purus hendrerit, if u interested hit me up!",
        imageRes = R.drawable.image1,
        profileImage = R.drawable.profile_pict
    ),
    MatchItem(
        title = "Project GG",
        desc = "Hi ! Kami adalah sebuah tim dari Universitas Indonesia, sedang mencari UI/UX designers untuk lomba balap karung Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce sodales gravida risus, vitae ultricies mi placerat et. Integer eu dapibus dolor. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aenean fermentum vehicula egestas. Sed id turpis quis lectus molestie pharetra. Nullam pulvinar erat eget purus hendrerit, if u interested hit me up!",
        imageRes = R.drawable.image2,
        profileImage = R.drawable.image1
    ),

    MatchItem(
        title = "Project GG 2",
        desc = "Hi ! Kami adalah sebuah tim dari Universitas Indonesia, sedang mencari UI/UX designers untuk lomba balap karung Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce sodales gravida risus, vitae ultricies mi placerat et. Integer eu dapibus dolor. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aenean fermentum vehicula egestas. Sed id turpis quis lectus molestie pharetra. Nullam pulvinar erat eget purus hendrerit, if u interested hit me up!",
        imageRes = R.drawable.image2,
        profileImage = R.drawable.image1
    ),
)

@Composable
fun CardPreview() {
    val cards = remember { mutableStateListOf(*data.toTypedArray()) }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(700.dp)
            .padding(12.dp)
        , contentAlignment = Alignment.Center
    ) {
        BackCard()

        cards.withIndex().reversed().forEach { (index, item) ->

            MatchCard(
                title = item.title,
                desc = item.desc,
                image = painterResource(id = item.imageRes),
                profile = painterResource(id = item.profileImage),
                index = index ,
                onMoveNext = {
                    if (index >= 0 && index <= cards.size) {
                        Log.d("CardPreview", "onMoveNext called for index: $index, size : ${cards.size}",)
                        val currentCard = cards[index]
//                        belum bisa reset card gatau anjg
                        cards.removeAt(index)
                    }
                }
            )

        }
    }
}

@Composable
private fun BackCard(){
    ElevatedCard(
        colors = CardDefaults.elevatedCardColors(
//                containerColor = CardBackground
//                containerColor = if (index == 0) CardBackground else CardBackground.copy(alpha = 0.5f)
            containerColor = CardBackground.copy(alpha = 0.5f)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(547.dp)
//                .offset(y = (index * -16).dp)
            .graphicsLayer { translationY = 16.dp.toPx() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            }

        }

    ElevatedCard(
        colors = CardDefaults.elevatedCardColors(
//                containerColor = CardBackground
//                containerColor = if (index == 0) CardBackground else CardBackground.copy(alpha = 0.5f)
            containerColor = CardBackground.copy(alpha = 0.5f)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(547.dp)
//                .offset(y = (index * -16).dp)
            .graphicsLayer { translationY = 32.dp.toPx() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

        }

    }
    }
