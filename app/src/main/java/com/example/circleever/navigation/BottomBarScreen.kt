package com.example.circleever.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
){
    object Societies: BottomBarScreen(
        route = "societies",
        title = "Societies",
        icon = Icons.Default.Home
    )

    object NoticeBoard: BottomBarScreen(
        route = "noticeBoard",
        title = "Notice Board",
        icon = Icons.Default.Person
    )

    object Help: BottomBarScreen(
        route = "help",
        title = "Help",
        icon = Icons.Default.Settings
    )
}
