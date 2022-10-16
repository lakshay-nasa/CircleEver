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
//            Log.d("SocietyView", "${result?.societyImageId} clicked")
//            Log.d("SocietyView", "${result?.id} clicked")

            SocietyView("${result?.title}", "${result?.about}", result!!.id ,navController)
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


@Composable
fun SocietyList(navController: NavController){
    Scaffold(
        content = {
            societyContent(navController)
        }
    )
}



@Composable
fun SocietyView(title: String, about: String, Id: Int, navController:NavController){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        var imageId = R.drawable.sampleicon
        var id = Id
        when (id){
            1 -> imageId = R.drawable.rpg
            2 -> imageId = R.drawable.goong
            3 -> imageId = R.drawable.goong
            4 -> imageId = R.drawable.npg
            5 -> imageId = R.drawable.pratibimb
            6 -> imageId = R.drawable.sunshine
            7 -> imageId = R.drawable.step
            8 -> imageId = R.drawable.swag
            9 -> imageId = R.drawable.savera
            10 -> imageId = R.drawable.think
            11 -> imageId = R.drawable.ska
            12 -> imageId = R.drawable.rebels
            13 -> imageId = R.drawable.wel
            else -> {
                R.drawable.sampleicon
            }
        }

        val SVobj = SocietyProfile( "${title}", "${about}", imageId)
        SVobj.Society_View(navController)
    }
}


@Composable
fun ContactView(title: String, facilitator1: String, facilitator2: String, contact1: String, contact2: String, instagramLink: String, linkedInLink: String){
    val CVobj = SocietyContact("${title}", facilitator1, facilitator2, contact1, contact2, instagramLink, linkedInLink)
    CVobj.ContactUs()
}




