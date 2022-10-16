package com.example.circleever

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.circleever.data.Society
import com.example.circleever.ui.theme.CircleEverTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircleEverTheme {
               MyApp()
            }
        }
    }
}

@Preview
@Composable
fun MyApp(){
    Navigation()
}

//@Preview
//@Composable
//fun MyApp(){
////    val obj1 = SocietyProfile("Natural Punjabi Dance Group", "ab")
//    val obj1 = SocietyProfile("Natural Punjabi Dance Group", "ab")
//    obj1.Society_View()
//}