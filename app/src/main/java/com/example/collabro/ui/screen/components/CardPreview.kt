package com.example.collabro.ui.screen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.collabro.R

data class MatchItem(val title: String, val desc: String, val imageRes: Int)

val data = listOf(
    MatchItem(
        title = "Lomba Innoverse",
        desc = "Hi ! Kami adalah sebuah tim dari Universitas Indonesia, sedang mencari UI/UX designers untuk lomba balap karung Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce sodales gravida risus, vitae ultricies mi placerat et. Integer eu dapibus dolor. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aenean fermentum vehicula egestas. Sed id turpis quis lectus molestie pharetra. Nullam pulvinar erat eget purus hendrerit, if u interested hit me up!",
        imageRes = R.drawable.image1),
)

@Composable
fun CardPreview(){
    data.forEach{
        item -> MatchCard(item.title,item.desc, image = painterResource(id = item.imageRes))
    }
}