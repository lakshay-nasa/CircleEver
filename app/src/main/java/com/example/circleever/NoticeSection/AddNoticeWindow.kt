package com.example.circleever.NoticeSection

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.circleever.ui.theme.SeaGreen
import kotlinx.coroutines.launch

class AddNoticeWindow {

    @SuppressLint("CoroutineCreationDuringComposition")
    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun AddNotice(
        noticeViewModel: NoticeViewModel?,
        noticeId: String,
        onNavigate: () -> Unit,
    ) {

        val noticeUiState = noticeViewModel?.noticeUiState ?: NoticeUiState()

        val isFormsNotBlank = noticeUiState.societyName.isNotBlank() && noticeUiState.noticeTitle.isNotBlank() && noticeUiState.noticeDetails.isNotBlank()

        val isNoticeIdNotBlank = noticeId.isNotBlank()
//        val icon = Icons.Default.Refresh
        val icon = if (isNoticeIdNotBlank) Icons.Default.Refresh
        else Icons.Default.Check
        LaunchedEffect(key1 = Unit) {
            if (isNoticeIdNotBlank) {
                noticeViewModel?.getNotice(noticeId)
//                noticeViewModel?.resetState()
            } else {
                noticeViewModel?.resetState()
            }
        }
        val scope = rememberCoroutineScope()

        val scaffoldState = rememberScaffoldState()



        Scaffold(
            modifier = Modifier
                .fillMaxHeight(0.94f),
            scaffoldState = scaffoldState,
            floatingActionButton = { // visible = isFormsNotBlank
                AnimatedVisibility(visible = true) {
                    FloatingActionButton(
                        onClick = {
                            if (isNoticeIdNotBlank) {
                                noticeViewModel?.updateNotice(noticeId)
                                Log.d("Tag", "Notice already exists.")

                            } else {
                                noticeViewModel?.addNotice()
                                Log.d("Tag", "Notice Added")

                            }
                        }
                    ) {
                        Icon(imageVector = icon, contentDescription = null)
                    }
                }
            },
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = SeaGreen)
                    .padding(padding)
            ) {
                if (noticeUiState.noticeAddedStatus) {
                    scope.launch {
                        scaffoldState.snackbarHostState
                            .showSnackbar("Added Notice Successfully")
                        noticeViewModel?.resetNoticeAddedStatus()
                        onNavigate.invoke()
                    }
                }

                if (noticeUiState.updateNoticeStatus) {
                    scope.launch {
                        scaffoldState.snackbarHostState
                            .showSnackbar("Notice Updated Successfully")
                        noticeViewModel?.resetNoticeAddedStatus()
                        onNavigate.invoke()
                    }
                }

                OutlinedTextField(value = noticeUiState.societyName,
                    onValueChange = {
                        noticeViewModel?.onSocietyNameChange(it)
                    },
                    label = { Text(text = "Society Name")},
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )

                OutlinedTextField(
                    value = noticeUiState.noticeTitle,
                    onValueChange = {
                        noticeViewModel?.onTitleChange(it)
                        println ("inside value change")
                    },
                    label = { Text(text = "Title") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )
                OutlinedTextField(
                    value = noticeUiState.noticeDetails,
                    onValueChange = { noticeViewModel?.onNoticeChange(it) },
                    label = { Text(text = "Notice") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(8.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )
                OutlinedTextField(
                    value = noticeUiState.noticeURL,
                    onValueChange = { noticeViewModel?.onURLChange(it) },
                    label = { Text(text = "Image/Poster URL") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f)
                        .padding(8.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    )
                )


            }


        }












//        Column(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            Text(text = "hello")
//
//        }



    }
}