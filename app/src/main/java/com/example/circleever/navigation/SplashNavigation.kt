package com.example.circleever

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SplashNavigation(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = MainScreen.ScreenSplash.route
    ){
        composable(
            MainScreen.ScreenSplash.route,
        ){
            ScreenSplash(navController = navController)
        }

        composable(
            MainScreen.BottomBar.route
        ){
            MainBottomBar()
        }
    }
}