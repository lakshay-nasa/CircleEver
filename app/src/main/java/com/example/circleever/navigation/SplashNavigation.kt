package com.example.circleever

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SplashNavigation(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = com.example.circleever.navigation.MainScreen.ScreenSplash.route
    ){
        composable(
            com.example.circleever.navigation.MainScreen.ScreenSplash.route,
        ){
            ScreenSplash(navController = navController)
        }

        composable(
            com.example.circleever.navigation.MainScreen.BottomBar.route
        ){
            MainBottomBar()
        }
    }
}