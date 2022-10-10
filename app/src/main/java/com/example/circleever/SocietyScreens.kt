package com.example.circleever

sealed class SocietyScreens(val route: String){
    object SocietyList : SocietyScreens("SocietyList")
    object SocietyView: SocietyScreens("SocietyView")
}