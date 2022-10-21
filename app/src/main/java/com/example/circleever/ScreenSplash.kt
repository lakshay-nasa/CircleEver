package com.example.circleever

import android.webkit.WebSettings.ZoomDensity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.circleever.ui.theme.Shapes
import kotlinx.coroutines.delay
import kotlin.contracts.Effect

@Composable

fun ScreenSplash(navController: NavHostController) {
    LaunchedEffect(key1 = true){
        delay(1500)
        navController.navigate(SocietyScreens.SocietyList.route){
            popUpTo(0)
        }
    }

    Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.cat), contentDescription = "cat")
    }

    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.circle_big), contentDescription = "logo" )
    }


}