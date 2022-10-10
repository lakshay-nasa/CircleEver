package com.example.circleever

import android.security.identity.AccessControlProfile
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.circleever.data.DataProvider
import com.example.circleever.data.Society

@Composable
fun societyContent(){
    val navController = rememberNavController()
    val societies = remember { DataProvider.societylist}
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 12.dp , vertical = 4.dp)
    ){
        items(
            items = societies,
            itemContent = {
                Societylistitem(
                    society = it, navController = navController,
                )
            }
        )
    }
}