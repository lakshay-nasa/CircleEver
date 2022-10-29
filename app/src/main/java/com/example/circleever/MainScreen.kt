package com.example.circleever

sealed class MainScreen(val route: String){
    object ScreenSplash: MainScreen(route = "ScreenSplash")
    object BottomBar: MainScreen(route = "BottomBar")
}
