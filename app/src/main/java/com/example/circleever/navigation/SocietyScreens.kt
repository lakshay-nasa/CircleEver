package com.example.circleever.navigation

sealed class SocietyScreens(val route: String){
    object SocietyList : SocietyScreens("SocietyList")
    object SocietyView: SocietyScreens("SocietyView")
    object ContactView: SocietyScreens("ContactView")
}