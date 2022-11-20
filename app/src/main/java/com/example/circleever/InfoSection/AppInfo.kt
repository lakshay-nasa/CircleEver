package com.example.circleever.InfoSection

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

class AppInfo {

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
                    .padding(5.dp)
                    .clip(RectangleShape),
                backgroundColor = Warmyellow
            )
            {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "Circle Ever",
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
                .padding(top = 10.dp),
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
                        text = "About App",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = maryKate,
                        modifier = Modifier
                            .padding(top = 20.dp, start = 10.dp),
                        color = Color(0xFFFCB144)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly


                        ) {
                        Text(
                            text = "An open source application created by students of Dcrust through which all the students and different societies can be connected on a single platform. The application will be a medium to connect freshers with different societies and help them to know about the various activities organised by them through our inbuilt notice board feature",                            fontSize = 20.sp,
                            modifier = Modifier.padding(top = 20.dp),
                            fontFamily = maryKate,
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
                            fontFamily = maryKate,
                            modifier = Modifier.padding(top = 40.dp),
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
                            fontFamily = maryKate,
                            text = "TEAM",
                            modifier = Modifier.padding(top = 15.dp),
                            fontSize = 15.sp,
                            color = Color(0xFFFFF8E5)

                        )
                        Text(
                            fontFamily = maryKate,
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
                            fontFamily = maryKate,
                            modifier = Modifier.padding(top = 40.dp),
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
                            fontFamily = maryKate,
                            text = "Interested open-source contributors can give their shots on the following\n" + "Github Repository : https://github.com/lakshay-nasa/CircleEver",
                            modifier = Modifier.padding(top = 15.dp, start = 10.dp),
                            fontSize = 15.sp,
                            color = Color(0xFFFFF8E5)

                        )
                    }









                }
            }
        }
    }

}