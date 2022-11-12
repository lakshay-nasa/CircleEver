package com.example.circleever

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.circleever.ui.theme.OldLace
import com.example.circleever.ui.theme.SeaGreen
import com.example.circleever.ui.theme.Warmyellow
import com.example.circleever.ui.theme.maryKate



@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NoticeBoard() {
    Surface(
        modifier = Modifier.fillMaxSize().background(color = SeaGreen),
        color = SeaGreen,
    ) {
        val isInsert = remember { mutableStateOf(false)}
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    isInsert.value = true
                }) {
                    Icon(
                        modifier = Modifier.background(color = Warmyellow),
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = OldLace,
                    )
                }
            },



            topBar = {
                SmallTopAppBar(
                    title = {
                        Text(
                            text = "Notice Board",
                            fontFamily = maryKate
                        )
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Warmyellow,
                        titleContentColor = OldLace
                    )
                )
            }
        ) { values ->
            LazyColumn(contentPadding = values) {
                items(2) {
                    NoticeCard(
                        title = "Bacon ipsum",
                        description = "Bacon ipsum dolor amet pork shankle beef andouille ball tip. Meatball corned beef swine, strip steak bacon jerky doner tongue biltong pork loin drumstick sausage hamburger burgdoggen." +
                                "Bacon ipsum dolor amet pork shankle beef andouille ball tip. Meatball corned beef swine, strip steak bacon jerky doner tongue biltong pork loin drumstick sausage hamburger burgdoggen.",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}