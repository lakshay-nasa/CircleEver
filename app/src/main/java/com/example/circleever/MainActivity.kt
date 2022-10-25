package com.example.circleever

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.circleever.ui.theme.CircleEverTheme
import com.example.circleever.ui.theme.SeaGreen
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircleEverTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = SeaGreen)
                ){
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    MainBottomBar()
}



@Composable
fun societyNavigation(){
    SocietyNavigation()
}

@Preview
@Composable
fun noticeBoard(){
    Text(text = "Hello")
}

@Composable
fun helpSection(){
    val obj1 = HelpSection()
    obj1.Help()
}





//@Preview
//@Composable
//fun MyApp(){
////    val obj1 = SocietyProfile("Natural Punjabi Dance Group", "ab")
//    val obj1 = SocietyProfile("Natural Punjabi Dance Group", "ab")
//    obj1.Society_View()
//}