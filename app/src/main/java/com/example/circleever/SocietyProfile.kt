package com.example.circleever

import android.util.Log
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.circleever.ui.theme.OldLace
import com.example.circleever.ui.theme.SeaGreen
import com.example.circleever.ui.theme.Warmyellow
import com.example.circleever.ui.theme.maryKate

class SocietyProfile(

    val sName: String,
    val sAbout: String,



) {
    @Composable
    fun Society_View(){
        SocietyName(modifier = Modifier)
        Column(modifier = Modifier
            .fillMaxSize().background(color = OldLace)
            .padding(top = 0.dp, bottom = 30.dp), verticalArrangement = Arrangement.Top,) {
            AboutPanel(modifier= Modifier)
        }
        Discussions(modifier = Modifier)
    }


    @Composable
    fun SocietyName(modifier: Modifier){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(modifier = Modifier
                .fillMaxWidth(0.8f)
//                .fillMaxHeight(0.08f)
                .clip(RectangleShape)
                .weight(1f, fill = false),
                backgroundColor = Warmyellow
            )
            {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "$sName",
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
    fun AboutPanel(modifier: Modifier) {
        Column(
            modifier = modifier
                .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
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
                    painter = painterResource(
                        id = R.drawable.jzaa
                    ),
                    contentDescription = "Society View",
                    Modifier.size(280.dp)
                )
            }

            Box(modifier = Modifier){
                Column(modifier
                    .padding(start = 15.dp, end = 15.dp, top = 0.dp, bottom = 10.dp)
                ) {
                    Card(modifier = Modifier.clip(RoundedCornerShape(topEndPercent = 4, topStartPercent = 4, bottomStartPercent = 10, bottomEndPercent = 10)),
                        backgroundColor = OldLace
                        ) {
                        Text(
                            text = "About Us",
                            textAlign = TextAlign.Start,
                            fontSize = 22.sp,
                            modifier = Modifier.padding(start = 10.dp)
                        )

                        val scroll = rememberScrollState(0)
                        Box(modifier = Modifier
                            .padding(10.dp, top = 30.dp)) {
                            Text(
                                text = "Jzaa - Oldest Dramatic Society Of Dcrust. " +
                                        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Eligendi sed tenetur quae vitae architecto expedita tempora at est unde. Incidunt rerum dolor, quis architecto unde totam numquam delectus aut dolorum? Adipisci amet iure, libero maiores inventore quas fugit itaque officiis nesciunt sint omnis vitae excepturi fugiat. Dolorem suscipit in magni minima alias libero ut numquam deleniti consequatur! Veniam, esse. Laboriosam, quas ipsum earum ab, cumque dolorem delectus nemo fuga voluptatibus vel ex laborum quia molestias quasi obcaecati similique et id nesciunt animi, ducimus saepe facilis voluptates? Esse reiciendis tempora et officiis fuga expedita neque eos a deleniti, error laborum eveniet ullam commodi. Maiores, dignissimos quidem! Doloremque eaque expedita, ratione ipsa fugit recusandae excepturi neque dignissimos perferendis pariatur omnis aspernatur praesentium nemo officiis? Nesciunt, dolores. Consequuntur quisquam voluptatum debitis voluptate distinctio libero qui voluptas molestias. Voluptatibus et accusamus nam doloribus minus qui, officiis error voluptates, veniam delectus ipsum quasi eveniet placeat quis natus ducimus harum nostrum temporibus, in quas ab cum! Ducimus voluptatum reprehenderit aspernatur accusantium saepe soluta debitis molestiae ipsum? Voluptas dolorum ut incidunt nesciunt facilis, officia veritatis rerum id natus dicta odio nisi fugiat! Dolore quod asperiores, dolorem excepturi voluptatum deserunt, nihil quam recusandae molestiae rerum illo minima animi? A, rerum ab molestiae quasi necessitatibus aliquam? Facere fugit rerum voluptas similique aliquid velit, aspernatur repudiandae necessitatibus non consectetur, ratione dicta vitae obcaecati at molestiae. Facere, nobis accusantium! Iure quaerat aspernatur officiis eius, autem necessitatibus laborum dignissimos molestiae dicta, a consectetur, sit eos hic.",
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
    fun Discussions(modifier: Modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(5.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            OutlinedButton(
                onClick = { Log.d("Button", "Opening Discussions") },
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