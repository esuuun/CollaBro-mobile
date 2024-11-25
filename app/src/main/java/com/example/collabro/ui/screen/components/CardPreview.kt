package com.example.collabro.ui.screen.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.collabro.R

data class MatchItem(val title: String, val desc: String, val imageRes: Int)

val data = listOf(
    MatchItem(
        title = "Lomba Innoverse",
        desc = "Hi ! Kami adalah sebuah tim dari Universitas Indonesia, sedang mencari UI/UX designers untuk lomba balap karung Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce sodales gravida risus, vitae ultricies mi placerat et. Integer eu dapibus dolor. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aenean fermentum vehicula egestas. Sed id turpis quis lectus molestie pharetra. Nullam pulvinar erat eget purus hendrerit, if u interested hit me up!",
        imageRes = R.drawable.image1),
    MatchItem(
        title = "Lomba 1",
        desc = "Hi ! Kami adalah sebuah tim dari Universitas Indonesia, sedang mencari UI/UX designers untuk lomba balap karung Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce sodales gravida risus, vitae ultricies mi placerat et. Integer eu dapibus dolor. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aenean fermentum vehicula egestas. Sed id turpis quis lectus molestie pharetra. Nullam pulvinar erat eget purus hendrerit, if u interested hit me up!",
        imageRes = R.drawable.image1),
    MatchItem(
        title = "Lomba 2",
        desc = "Hi ! Kami adalah sebuah tim dari Universitas Indonesia, sedang mencari UI/UX designers untuk lomba balap karung Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce sodales gravida risus, vitae ultricies mi placerat et. Integer eu dapibus dolor. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aenean fermentum vehicula egestas. Sed id turpis quis lectus molestie pharetra. Nullam pulvinar erat eget purus hendrerit, if u interested hit me up!",
        imageRes = R.drawable.image1),
)

@Composable
fun CardPreview() {
    val cards = remember { mutableStateListOf(*data.toTypedArray()) }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(700.dp)
            .padding(12.dp)
    ) {

            cards.reversed().forEachIndexed { index, item ->

                MatchCard(
                    title = item.title,
                    desc = item.desc,
                    image = painterResource(id = item.imageRes),

                    onMoveNext = {
                        if (index <= cards.size - 1) {
                            Log.d("CardPreview", "onMoveNext called for index: $index")
                            val currentCard = cards.removeAt(0)
                            cards.add(currentCard)
                        }
                    }
                )
        }
    }
}