package com.example.circleever

import android.view.animation.OvershootInterpolator
import android.webkit.WebSettings.ZoomDensity
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.circleever.ui.theme.Shapes
import com.example.circleever.ui.theme.maryKate
import kotlinx.coroutines.delay
import kotlin.contracts.Effect

@Composable

fun ScreenSplash(navController: NavHostController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(1000L)
        navController.navigate(SocietyScreens.SocietyList.route){
            popUpTo(0)
        }
    }
    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {

        Image(painter = painterResource(id = R.drawable.logo1),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value))
        /*Text(text = "Circle Ever",
            fontFamily = maryKate,
            fontSize = 44.sp,
            textAlign = TextAlign.Start)*/
    }

    /*Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.cat), contentDescription = "cat")
    }


*/

}