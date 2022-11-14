package com.example.circleever.NoticeSection

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.circleever.SocietyList
import com.example.circleever.navigation.SocietyScreens
import com.example.circleever.noticeBoard
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun NoticeBoardNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SocietyScreens.SocietyList.route)
    {
        composable(
            route = NoticeBoardScreens.NoticeBoard.route
        ){
            noticeBoard(navController)
        }

        composable(
            route = NoticeBoardScreens.NoticeBoardLogin.route

        ){
            val auth by lazy {
                Firebase.auth
            }
            NoticeBoardLogin(auth, navController)
        }

        composable(
            route = NoticeBoardScreens.AddNoticeWindow.route
        ){
            val noticeId = Firebase.auth.currentUser?.uid.orEmpty()
            val noticeObj1 = AddNoticeWindow()
            noticeObj1.AddNotice(noticeViewModel = NoticeViewModel(), noticeId = noticeId){

            }
        }

    }
}