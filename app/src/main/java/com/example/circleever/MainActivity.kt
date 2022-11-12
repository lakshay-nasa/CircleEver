package com.example.circleever

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.circleever.ui.theme.CircleEverTheme
import com.example.circleever.ui.theme.SeaGreen
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.circleever.InfoSection.AppInfo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircleEverTheme {
                Box(
                    modifier = Modifier.background(color = SeaGreen)
                ){
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    MainScreen()
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    SplashNavigation(navController = navController)
    
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
    Box(modifier = Modifier.fillMaxHeight(0.935f)) {
        NoticeBoard()
    }
}

@Composable
fun helpSection(){
        val obj1 = AppInfo()
        obj1.Help()
}