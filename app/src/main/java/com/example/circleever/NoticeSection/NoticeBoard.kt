package com.example.circleever

import android.app.Dialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.circleever.ui.theme.OldLace
import com.example.circleever.ui.theme.SeaGreen
import com.example.circleever.ui.theme.Warmyellow
import com.example.circleever.ui.theme.maryKate
import androidx.compose.material.Card
import androidx.compose.ui.Alignment
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.runtime.MutableState
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import com.example.circleever.NoticeSection.*
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.circleever.navigation.SocietyScreens


//val showDialog = mutableStateOf(false)



@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NoticeBoard(navController: NavController) {

//    val dialogState: MutableState<Boolean> = remember {
//        mutableStateOf(false)
//    }
//
//
//    if (dialogState.value) {
//        Dialog(
//            onDismissRequest = { dialogState.value = false },
//            content = {
//                CompleteDialogContent("Please Login First", dialogState, "") { BodyContent() }
//            },
//            properties = DialogProperties(
//                dismissOnBackPress = false,
//                dismissOnClickOutside = false
//            )
//        )
//        dvm.doSomethingMore()
//    }
//    else {
//        Toast.makeText(ctx, "Dialog Closed", Toast.LENGTH_SHORT).show()
//        dvm.doSomething()
//    }



    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SeaGreen),
        color = SeaGreen,
    ) {
        val isInsert = remember { mutableStateOf(false)}
        Scaffold(

            // Button To Add Notice
            floatingActionButton = {
                FloatingActionButton(onClick = {
                                               Log.d("AddButton", "Button Pressed")
                    navController.navigate(NoticeBoardScreens.NoticeBoardLogin.route)

//                    dialogState.value = true
                }, modifier = Modifier
                    .clip(shape = CircleShape)
                    .shadow(50.dp, ambientColor = Color.Black)) {
                    Icon(
                        modifier = Modifier
                            .background(color = Warmyellow)
                            .padding(18.dp),
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = SeaGreen,
                    )
                }
            },


            // Notice Section Heading
            topBar = {
                Card(modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .clip(RectangleShape)
                    .padding(start = 80.dp),
                    backgroundColor = Warmyellow,

                ){
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "Notice Board",
                        textAlign = TextAlign.Center,
                        color = SeaGreen,
                        fontSize = 35.sp,
                        fontFamily = maryKate,
                        fontWeight = FontWeight.Thin,
                        maxLines = 2,
                        overflow = TextOverflow.Clip
                    )
                }
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