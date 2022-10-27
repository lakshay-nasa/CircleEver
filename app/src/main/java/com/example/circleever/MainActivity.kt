package com.example.circleever

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.circleever.ui.theme.CircleEverTheme
import com.example.circleever.ui.theme.SeaGreen
import androidx.compose.ui.Modifier
import com.example.circleever.ui.theme.OldLace

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircleEverTheme {
                Box(
                    modifier = Modifier
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
    Box(modifier = Modifier.fillMaxHeight(0.935f)) {
        SocietyNavigation()
    }
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