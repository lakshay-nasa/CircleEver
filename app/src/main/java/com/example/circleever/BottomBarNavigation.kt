package com.example.circleever

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomBarNavigation(navController: NavHostController){
    NavHost(navController = navController,
    startDestination = BottomBarScreen.Societies.route
        ){
        composable(route = BottomBarScreen.Societies.route){
            // Societies Screen Goes Here
        }

        composable(route = BottomBarScreen.Societies.route){
            // Notice Board Goes here
        }

        composable(route = BottomBarScreen.Societies.route){
            // Help Section Goes here
        }
    }
}