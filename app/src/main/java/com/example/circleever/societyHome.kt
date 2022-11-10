package com.example.circleever

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.circleever.data.DataProvider
import com.example.circleever.models.SocietiesViewModel
import com.example.circleever.repo.SocietiesRepository
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.circleever.data.Societies
import kotlinx.coroutines.flow.asStateFlow


@Composable
fun societyContent(navController:NavController,
                   societiesViewModel: SocietiesViewModel = viewModel(
    factory = SocietiesViewModelFactory(SocietiesRepository()))
){
//    val societies2 = remember { DataProvider.societylist}

    when (val societiesList = societiesViewModel.societiesStateFlow.asStateFlow().collectAsState().value){
        is OnError -> {
            Text(text = "Please try after sometime.")
        }

        is  OnSuccess -> {
            val listOfSocieties = societiesList.querySnapshot?.toObjects(Societies::class.java)
            listOfSocieties?.let {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 12.dp , vertical = 4.dp),
                ){
                    items(listOfSocieties) {
                        SocietyListItem(navController = navController, societies = it )
                    }
//                    items(
//                        items = societies,
//                        itemContent = {
//                            SocietyListItem(
//                                society = it, navController = navController, societies = it,
//                            )
//                        }
//                    )
                }
            }
        }
    }
}