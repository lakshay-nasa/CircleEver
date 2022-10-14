package com.example.circleever

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.circleever.data.Society
import java.lang.System.console

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SocietyScreens.SocietyList.route)
    {
        composable(route = SocietyScreens.SocietyList.route){
            SocietyList(navController = navController)
        }

        composable(
            route = SocietyScreens.SocietyView.route,
        ){
            SocietyView()
        }
    }
}


// <------- Testing -------> Note -> Comment below "SocietyList" before uncommenting it.
//@Composable
//fun SocietyList(navController: NavController){
//Column(
//    verticalArrangement = Arrangement.Center,
//    modifier = Modifier
//        .fillMaxWidth()
//        .padding(horizontal = 50.dp)
//) {
//    Button(
//        onClick = {
//            navController.navigate(SocietyScreens.SocietyView.route)
//        },
//    ) {
//        Text(text = "To NavigateScreen")
//    }
//}
//}


@Composable
fun SocietyList(navController: NavController){
    Scaffold(
        content = {
            societyContent()
        }
    )
}


// <------- Testing (App Crashing) ------->
// Note - This is texting code, will update once the problem is solved.
// --> App doesn't navigate to below function when society is clicked.

@Composable
fun SocietyView(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Hello")
    }
}




//@Composable
//fun SocietyView(){
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier.fillMaxSize()
//    ){
//        val obj1 = SocietyProfile("Natural Punjabi Dance Group", "ab")
//        obj1.Society_View()
//    }
//}
