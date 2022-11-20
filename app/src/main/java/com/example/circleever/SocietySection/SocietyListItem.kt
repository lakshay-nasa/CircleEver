package com.example.circleever.SocietySection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.circleever.data.Societies
import com.example.circleever.models.SocietiesViewModel
import com.example.circleever.navigation.SocietyScreens
import com.example.circleever.repo.SocietiesRepository
import com.example.circleever.ui.theme.OldLace
import com.example.circleever.ui.theme.SeaGreen
import com.example.circleever.ui.theme.maryKate


@Preview
@Composable
//fun SocietyListItem(society: Society, navController: NavController, societies: Societies) {
fun SocietyListItem(navController: NavController, societies: Societies) {

    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(color = SeaGreen)
    ) {

        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            backgroundColor = OldLace,
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ) {
            Row(
                // <------- Testing ------->
//            Modifier.clickable(onClick = { Log.d("Button", "${society.title} is Clicked")})

                Modifier.clickable {
                    val societyDetails = Societies(
                        title = societies.title,
                        about = societies.about,
                        tagLine = societies.tagLine,
                        achievement0 = societies.achievement0,
                        achievement1 = societies.achievement1,
                        achievement2 = societies.achievement2,
                        achievement3 = societies.achievement3,
                        achievement4 = societies.achievement4,
                        coordinator1 = societies.coordinator1,
                        coordinator2 = societies.coordinator2,
                        coordinatorDetails1 = societies.coordinatorDetails1,
                        coordinatorDetails2 = societies.coordinatorDetails2,
                        SocialLink1 = societies.socialLink1,
                        SocialLink2 = societies.socialLink2,
                        SocialLink3 = societies.socialLink3,
                        SocialLink4 = societies.socialLink4,
                    )

                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        key = "societyDetails",
                        value = societyDetails
                    )
                    navController.navigate(SocietyScreens.SocietyView.route)
                },
            ) {
                SocietyImage(societies = societies)
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = societies.title,
                        style = typography.h6,
                        fontFamily = maryKate,
                        color = Color.Black
                    )
                    Text(
                        text = "VIEW DETAIL",
                        style = typography.body2,
                        color = Color.Black

                    )
                }
            }
        }
    }
}


@Composable
private fun SocietyImage(societies: Societies){
    Image(
        painter = rememberAsyncImagePainter(societies.logoURL),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(20.dp)))

    )
}


class SocietiesViewModelFactory(private val societiesRepository: SocietiesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(SocietiesViewModel::class.java)) {
            return SocietiesViewModel(SocietiesRepository()) as T
        }
        throw IllegalStateException()
    }
}

