package com.example.circleever

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.circleever.navigation.BottomBarScreen

@Composable
fun BottomBarNavigation(navController: NavHostController){
    NavHost(navController = navController,
    startDestination = BottomBarScreen.Societies.route
        ){
        composable(route = BottomBarScreen.Societies.route){
            societyNavigation()
        }

        composable(route = BottomBarScreen.NoticeBoard.route){
            noticeBoard()
        }

        composable(route = BottomBarScreen.Help.route){
            helpSection()
        }
    }
}