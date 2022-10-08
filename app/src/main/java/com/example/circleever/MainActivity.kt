package com.example.circleever

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.circleever.data.Society
import com.example.circleever.ui.theme.CircleEverTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircleEverTheme {
               MyApp(){
                   startActivity(Intent(this, ProfileActivity:: class.java))
               }
            }
        }
    }
}

@Composable
fun MyApp(navigateToProfile: (Society) -> Unit){
    Scaffold(
        content = {
            societyContent(navigateToProfile = navigateToProfile)
        }
    )

}