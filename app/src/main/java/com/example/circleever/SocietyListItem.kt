package com.example.circleever

import android.icu.text.CaseMap.Title
import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.circleever.data.DataProvider
import com.example.circleever.data.Society


@Composable
fun societyClicked(){
}


@Composable
fun SocietyListItem(society: Society, navController: NavController){
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.DarkGray,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(
            // <------- Testing ------->
//            Modifier.clickable(onClick = { Log.d("Button", "${society.title} is Clicked")})

            Modifier.clickable{
                val societyDetails = Society(
                    title = "${society.title}",
                    about = "${society.about}",
                    description = "${society.description}",
                    id = society.id,
                    societyImageId = society.id,
                    facilitator1 = "${society.facilitator1}",
                    facilitator2 = "${society.facilitator2}",
                    contact1 = "${society.contact1}",
                    contact2 = "${society.contact2}",
                    InstagramLink = "${society.InstagramLink}",
                    LinkedInLink = "${society.LinkedInLink}"
                    )

                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "societyDetails",
                    value = societyDetails
                )
                navController.navigate(SocietyScreens.SocietyView.route)
                              },
        ) {
            SocietyImage(society = society)
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = society.title, style = typography.h6)
                Text(text = "VIEW DETAIL", style = typography.caption)
            }
        }
    }
}


@Composable
private fun SocietyImage(society: Society){
    Image(
        painter = painterResource(id = society.societyImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))

    )
}