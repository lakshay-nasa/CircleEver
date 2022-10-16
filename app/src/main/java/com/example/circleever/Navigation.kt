package com.example.circleever

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.circleever.data.Society

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SocietyScreens.SocietyList.route)
    {
        composable(
            route = SocietyScreens.SocietyList.route
        ){
            SocietyList(navController = navController)
        }

        composable(
            route = SocietyScreens.SocietyView.route,
        ){
            val result =
                navController.previousBackStackEntry?.savedStateHandle?.get<Society>("societyDetails")

//            <------- Testing ------->
//            Log.d("SocietyView", "${result?.title}")
//            Log.d("SocietyView", "${result?.about}")

            SocietyView("${result?.title}", "${result?.about}", navController)
        }


        composable(
            route = SocietyScreens.ContactView.route,
        ){
            val result =
                navController.previousBackStackEntry?.savedStateHandle?.get<Society>("societyDetails")

//                        Log.d("SocietyView", "${result?.facilitators}")

//            ContactView("${result?.title}", arrayOf(result?.facilitators), result.contact, result.societySocialLinks)
            ContactView("${result?.title}", "${result?.facilitator1}", "${result?.facilitator2}", "${result?.contact1}", "${result?.contact2}", "${result?.InstagramLink}", "${result?.LinkedInLink}")
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
            societyContent(navController)
        }
    )
}



@Composable
fun SocietyView(title: String, about: String, navController:NavController){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        val SVobj = SocietyProfile( "${title}", "${about}")
        SVobj.Society_View(navController)
    }
}


@Composable
fun ContactView(title: String, facilitator1: String, facilitator2: String, contact1: String, contact2: String, instagramLink: String, linkedInLink: String){
//    val CVobj = SocietyContact("${facilitators}", "${contact}", "${links}")
    val CVobj = SocietyContact("${title}", facilitator1, facilitator2, contact1, contact2, instagramLink, linkedInLink)
    CVobj.ContactUs()
}


//@Preview
//@Composable
//fun ContactView(){
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier.fillMaxSize()
//    ){
//        Text(text = "ContactWindow")
//    }
//}


