package com.example.circleever

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

class HelpSection {
    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun Help() {
        SocietyHelp(modifier = Modifier)
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Help(modifier = Modifier)
        }
//        Links(modifier = Modifier)
    }


    @Composable
    fun SocietyHelp(modifier: Modifier) {
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
                    .clip(RectangleShape),
                backgroundColor = Warmyellow
            )
            {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "Help ⛑",
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
    fun Help(modifier: Modifier) {
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
                        text = "About",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 20.dp),
                        color = Color(0xFFFCB144)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(),
                        horizontalArrangement = Arrangement.SpaceEvenly


                        ) {
                        Text(
                            text = "An application through which all the students and different societies can be connected on one platform. The application will provide an introduction to different societies and what a student will learn if they join the society. We provide a platform for all the societies to announce their events and make them reach each and every student.",
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
                            text = "Contributors Panel",
                            fontSize = 20.sp,
                            modifier = Modifier.padding(top = 80.dp),
                            color = Color(0xFFFCB144)

                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(),
                        horizontalArrangement = Arrangement.SpaceEvenly


                    ) {
                        Text(
                            text = "Aditi",
                            modifier = Modifier.padding(top = 15.dp),
                            fontSize = 15.sp,
                            color = Color(0xFFFFF8E5)

                        )
                        Text(
                            text = "Link:XXXXXXX",
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
                            text = "Contribution Opportunities",
                            fontSize = 20.sp,
                            modifier = Modifier.padding(top = 80.dp),
                            color = Color(0xFFFCB144)

                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(),
                        horizontalArrangement = Arrangement.SpaceEvenly


                    ) {
                        Text(
                            text = "Interested open-source contributors can give their shots on the following\n" + "Github Repository : https://github.com/lakshay-nasa/CircleEver",
                            modifier = Modifier.padding(top = 15.dp),
                            fontSize = 15.sp,
                            color = Color(0xFFFFF8E5)

                        )
                    }









                }
            }
        }
    }

}