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
import com.example.circleever.SocietySection.SocietyContact
import com.example.circleever.SocietySection.SocietyProfile
import com.example.circleever.data.Societies
import com.example.circleever.navigation.SocietyScreens

@Composable
fun SocietyNavigation() {
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
                navController.previousBackStackEntry?.savedStateHandle?.get<Societies>("societyDetails")

//            <------- Testing ------->
//            Log.d("SocietyView", "${result?.title}")
//            Log.d("SocietyView", "${result?.about}")
            Log.d("SocietyView", "${result?.logoURL} clicked")
            Log.d("SocietyView", "${result?.title} clicked")

            SocietyView("${result?.title}",
                "${result?.about}",
                "${result?.tagLine}",
                "${result?.achievement0}",
                "${result?.achievement1}",
                "${result?.achievement2}",
                "${result?.achievement3}",
                "${result?.achievement4}",
                "${result?.logoURL}",
                "${result?.contactDetails}",
                "${result?.coordinator1}",
                "${result?.coordinatorDetails1}",
                "${result?.coordinator2}",
                "${result?.coordinatorDetails2}",
                "${result?.socialLink1}",
                "${result?.socialLink2}",
                "${result?.socialLink3}",
                "${result?.socialLink4}",
            navController)
        }



        composable(
            route = SocietyScreens.ContactView.route,
        ){
            val result =
                navController.previousBackStackEntry?.savedStateHandle?.get<Societies>("societyDetails")

//                        Log.d("SocietyView", "${result?.facilitators}")

//            ContactView("${result?.title}", arrayOf(result?.facilitators), result.contact, result.societySocialLinks)
            ContactView("${result?.title}", "${result?.coordinator1}", "${result?.coordinatorDetails1}", "${result?.coordinator2}", "${result?.coordinatorDetails2}", "${result?.socialLink1}", "${result?.socialLink2}", "${result?.socialLink3}", "${result?.socialLink4}")
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
            SocietyListContent(navController)
        }
    )
}



@Composable
fun SocietyView(
    title: String,
    about: String,
    tagLine: String,
    achievement0: String,
    achievement1: String,
    achievement2: String,
    achievement3: String,
    achievement4: String,
    logoURL: String,
    contactDetails: String,
    coordinator1: String,
    coordinatorDetails1: String,
    coordinator2: String,
    coordinatorDetails2: String,
    socialLink1: String,
    socialLink2: String,
    socialLink3: String,
    socialLink4: String,
    navController:NavController){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        val SVobj = SocietyProfile(title, about, tagLine, achievement0, achievement1, achievement2, achievement3, achievement4, logoURL, contactDetails, coordinator1, coordinatorDetails1, coordinator2, coordinatorDetails2, socialLink1, socialLink2, socialLink3, socialLink4)
        SVobj.Society_View(navController)
    }
}


@Composable
fun ContactView(title: String, coordinator1: String, coordinatorDetails1: String, coordinator2: String, coordinatorDetails2: String, socialLink1: String, socialLink2: String, socialLink3: String, socialLink4: String){
//    val CVobj = SocietyContact("${facilitators}", "${contact}", "${links}")
    val CVobj = SocietyContact(title, coordinator1, coordinatorDetails1, coordinator2, coordinatorDetails2, socialLink1, socialLink2, socialLink3, socialLink4)
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
//    }
//}
