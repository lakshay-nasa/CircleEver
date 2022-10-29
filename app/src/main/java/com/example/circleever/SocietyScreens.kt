package com.example.circleever

sealed class SocietyScreens(val route: String){
    object SocietyList : SocietyScreens("SocietyList")
    object SocietyView: SocietyScreens("SocietyView")
    object ContactView: SocietyScreens("ContactView")
    object screenSplash: SocietyScreens(route = "splash")
}