package com.example.circleever.NoticeSection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class AddNoticeWindow {

    @Composable
    fun AddNotice() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "hello")

//            OutlinedTextField(
//                value = detailUiState.title,
//                onValueChange = {
//                    detailViewModel?.onTitleChange(it)
//                },
//                label = { Text
//                    (text = "Title") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//            )
//            OutlinedTextField(
//                value = detailUiState.note,
//                onValueChange = { detailViewModel?.onNoteChange(it) },
//                label = { Text(text = "Notes") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(1f)
//                    .padding(8.dp)
//            )
//        }
//    }

        }
    }
}