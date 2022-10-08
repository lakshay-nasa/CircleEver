package com.example.circleever

import android.security.identity.AccessControlProfile
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.circleever.data.DataProvider
import com.example.circleever.data.Society

@Composable
fun societyContent(navigateToProfile: (Society) -> Unit){
    val societies = remember { DataProvider.societylist}
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 12.dp , vertical = 4.dp)
    ){
        items(
            items = societies,
            itemContent = {
                 SocietyListItem(
                     society = it, navigateToProfile
                 )
            }
        )
    }
}