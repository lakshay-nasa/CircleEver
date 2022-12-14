package com.example.circleever.SocietySection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.circleever.ui.theme.OldLace
import com.example.circleever.ui.theme.SeaGreen
import com.example.circleever.ui.theme.Warmyellow
import com.example.circleever.ui.theme.maryKate

class SocietyContact(

    val title: String,
    val coordinator1: String,
    val coordinatorDetails1: String,
    val coordinator2: String,
    val coordinatorDetails2: String,
    val socialLink1: String,
    val socialLink2: String,
    val socialLink3: String,
    val socialLink4: String,



    ) {
//    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun ContactUs() {
        SocietyName(modifier = Modifier)
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
        ) {
            ContactWindow(modifier = Modifier)
        }
//        Links(modifier = Modifier)
    }




    @Composable
    fun SocietyName(modifier: Modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize().background(color = OldLace)
                .padding(1.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth(0.8f)
                    .clip(RectangleShape)
                    .weight(1f, fill = false),
                backgroundColor = Warmyellow
            )
            {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "$title",
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


    @Composable
    fun ContactWindow(modifier: Modifier) {
        Column(
            modifier = Modifier
                .padding(top = 50.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
                    .clip(RoundedCornerShape(topStartPercent = 10, topEndPercent = 10)),

                ) {
                Column(
                    modifier = Modifier
                        .background(color = SeaGreen),
                ) {
                    Text(
                        text = "Contact Us",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 20.dp, start = 10.dp),
                        color = Color(0xFFFCB144)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(),
                        horizontalArrangement = Arrangement.SpaceEvenly,


                        ) {
                        Text(
                            text = "Co-ordinators",
                            fontSize = 20.sp,
                            modifier = Modifier.padding(top = 20.dp),
                            color = Color(0xFFFFF8E5)
                        )
                        Text(
                            text = "Contact Details",
                            fontSize = 20.sp,
                            modifier = Modifier.padding(top = 20.dp),
                            color = Color(0xFFFFF8E5)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(),
                        horizontalArrangement = Arrangement.SpaceEvenly


                    ) {
                        Text(
                            text = "$coordinator1",
                            modifier = Modifier.padding(top = 15.dp),
                            fontSize = 15.sp,

                            )
                        Text(
                            text = "$coordinatorDetails1",
                            modifier = Modifier.padding(top = 15.dp),
                            fontSize = 15.sp,


                            )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(),
                        horizontalArrangement = Arrangement.SpaceEvenly


                    ) {
                        Text(
                            text = "$coordinator2",
                            modifier = Modifier.padding(top = 15.dp),
                            fontSize = 15.sp,

                            )
                        Text(
                            text = "$coordinatorDetails2",
                            modifier = Modifier.padding(top = 15.dp),
                            fontSize = 15.sp,


                            )
                    }

                    Text(
                        text = "Follow Us",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 80.dp, start = 10.dp),
                        color = Color(0xFFFCB144)

                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(),
                        horizontalArrangement = Arrangement.SpaceEvenly


                    ) {
                        Text(
                            text = "$socialLink1",
                            modifier = Modifier.padding(top = 15.dp),
                            fontSize = 15.sp,
                            color = Color(0xFFFFF8E5)

                            )
                        Text(
                            text = "$socialLink2",
                            modifier = Modifier.padding(top = 15.dp),
                            fontSize = 15.sp,


                            )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(),
                        horizontalArrangement = Arrangement.SpaceEvenly


                    ) {
                        Text(
                            text = "$socialLink3",
                            modifier = Modifier.padding(top = 15.dp),
                            fontSize = 15.sp,
                            color = Color(0xFFFFF8E5)

                            )
                        Text(
                            text = "$socialLink4",
                            modifier = Modifier.padding(top = 15.dp),
                            fontSize = 15.sp,
                        )
                    }



                }
            }
        }
    }

}