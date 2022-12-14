package com.example.circleever.SocietySection

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.circleever.R
import com.example.circleever.navigation.SocietyScreens
import com.example.circleever.ui.theme.OldLace
import com.example.circleever.ui.theme.SeaGreen
import com.example.circleever.ui.theme.Warmyellow
import com.example.circleever.ui.theme.maryKate

class SocietyProfile(

    val title: String,
    val about: String,
    val tagLine: String,
    val achievement0: String,
    val achievement1: String,
    val achievement2: String,
    val achievement3: String,
    val achievement4: String,
    val logoURL: String,
    val contactDetails: String,
    val coordinator1: String,
    val coordinatorDetails1: String,
    val coordinator2: String,
    val coordinatorDetails2: String,
    val socialLink1: String,
    val socialLink2: String,
    val socialLink3: String,
    val socialLink4: String,



) {
    //contactUS_Button
    @Composable
    fun Society_View(navController: NavController){
        SocietyName(modifier = Modifier)
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = OldLace)
            .padding(top = 0.dp, bottom = 30.dp), verticalArrangement = Arrangement.Top,) {
            AboutPanel(modifier= Modifier)
        }
        SocietyContactBtn(navController)
    }


    // Top Heading for page
    @Composable
    fun SocietyName(modifier: Modifier){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                .fillMaxWidth(0.8f)
//                .fillMaxHeight(0.08f)
                .clip(RectangleShape)
                .weight(1f, fill = false),
                backgroundColor = Warmyellow
            )
            {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = title,
                    textAlign = TextAlign.Center,
                    color = SeaGreen,
                    fontSize = 35.sp,
                    fontFamily = maryKate,
                    fontWeight = FontWeight.Thin,
                    maxLines = 2,
                    overflow = TextOverflow.Clip
                )
            }
        }

    }





    // center image of society
    @Composable
    fun AboutPanel(modifier: Modifier) {
        Column(
            modifier = modifier
                .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
                .background(color = SeaGreen),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(modifier = Modifier
                .padding(5.dp, top = 100.dp, bottom = 20.dp)
                .clip(CircleShape)
            ) {
                Image(
//                    painter = painterResource(
////                        id = imageId.toInt()
//                    id = R.drawable.sampleicon
//                    ),
                    painter = rememberAsyncImagePainter(logoURL),
                    contentDescription = "Society View",
                    Modifier.size(280.dp)
                )
            }

            Box(modifier = Modifier){
                Column(modifier
                    .padding(start = 15.dp, end = 15.dp, top = 0.dp, bottom = 10.dp)
                ) {
                    // Heading About Us
                    Card(modifier = Modifier.clip(RoundedCornerShape(topEndPercent = 4, topStartPercent = 4, bottomStartPercent = 10, bottomEndPercent = 10)),
                        backgroundColor = OldLace
                        ) {
                        Text(
                            text = "About Us",
                            textAlign = TextAlign.Start,
                            color = SeaGreen,
                            fontFamily = maryKate,
                            fontSize = 22.sp,
                            modifier = Modifier.padding(start = 10.dp, top = 4.dp)
                        )

                        // Content of about us
                        val scroll = rememberScrollState(0)
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp, top = 30.dp)) {
                            Text(
                                text = "$about \n $tagLine \n $achievement0 \n $achievement1 \n $achievement2 \n $achievement3 \n $achievement4",
                                color = Color.Black,
                                fontFamily = maryKate,
                                textAlign = TextAlign.Start,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .height(200.dp)
                                    .verticalScroll(scroll)

                            )

                        }
                    }
                }
            }
        }
    }





    @Composable
    fun SocietyContactBtn(navController: NavController) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(5.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            OutlinedButton(
//                onClick = { Log.d("Button", "Opening Contact") },
                onClick = {

                    navController.popBackStack()   // This will save the data for now while navigation.

                    navController.navigate(SocietyScreens.ContactView.route)
                          },
                shape = RoundedCornerShape(20),
                modifier = Modifier.padding(20.dp),
                contentPadding = PaddingValues(15.dp),
                border = BorderStroke(0.5.dp, Color.DarkGray),
                colors = ButtonDefaults.buttonColors(backgroundColor = Warmyellow)
            ) {
                Text(
                    text = "Contact Us",
                    fontSize = 22.sp,
                    fontFamily = maryKate,
                )
            }
        }

    }

}