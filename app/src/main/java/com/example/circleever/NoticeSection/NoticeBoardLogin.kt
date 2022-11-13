package com.example.circleever.NoticeSection

import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.circleever.NoticeBoard
import com.example.circleever.ui.theme.SeaGreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun CompleteDialogContent(
    title: String,
    dialogState: MutableState<Boolean>,
    successButtonText: String,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxHeight(0.7f)
            .fillMaxWidth(1f),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TitleAndButton(title, dialogState)
            AddBody(content)
            BottomButtons(successButtonText, dialogState = dialogState)
        }
    }
}

@Composable
private fun TitleAndButton(title: String, dialogState: MutableState<Boolean>) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title, fontSize = 24.sp)
            IconButton(modifier = Modifier.then(Modifier.size(24.dp)),
                onClick = {
                    dialogState.value = false
                }) {
                Icon(
                    Icons.Filled.Close,
                    "contentDescription"
                )
            }
        }
        Divider(color = Color.DarkGray, thickness = 1.dp)
    }
}

@Composable
private fun BottomButtons(successButtonText: String, dialogState: MutableState<Boolean>) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxWidth(1f)
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(0.dp),
//                .padding(start = 10.dp),
            shape = RoundedCornerShape(16.dp),

            ) {
            Text(text = "Cancel", fontSize = 20.sp)
        }
        Button(
            onClick = {
                dialogState.value = false
            },
            modifier = Modifier.width(100.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(text = successButtonText, fontSize = 20.sp)
        }

    }
}

@Composable
private fun AddBody(content: @Composable () -> Unit) {

//    companion object {
//    object {
//        val TAG: String = NoticeBoard()::class.java.simpleName
//    }

//    private val auth by lazy {
    val auth by lazy {
        Firebase.auth
    }
    Box(
        modifier = Modifier
            .padding(20.dp)
    ) {
//        content()
        LoginScreen(auth)
    }
}


@Composable
fun BodyContent() {
    Text(
        text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "
        ,
        fontSize = 22.sp
    )
}


@Preview
@Composable
private fun LoginScreen(auth: FirebaseAuth) {

    val focusManager = LocalFocusManager.current

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val isEmailValid by derivedStateOf {
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    val isPasswordValid by derivedStateOf {
        password.length > 7
    }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .background(color = SeaGreen)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {


        OutlinedTextField(value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email Address") },
            placeholder = { Text("abc@domail.com") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),

            isError = !isEmailValid,
            trailingIcon = {
                if (email.isNotBlank()){
                    IconButton(onClick = { email = ""}) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "Clear email"
                        )
                    }
                }
            }


        )

        OutlinedTextField(value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),

            isError = !isPasswordValid,
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible}) {
                    Icon(imageVector = if(isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff, contentDescription = "toggle password visibility")
                }
            },

            visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()


        )

        Button(onClick = {
                         auth.signInWithEmailAndPassword(email, password)
                             .addOnCompleteListener {
                                 if (it.isSuccessful){
                                     Log.d("Tag", "User Login Success.")
                                 } else {
                                     Log.w("Tag", "User Login Failed.", it.exception)
                                 }
                             }
        },
            modifier = Modifier.fillMaxWidth(0.5f),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            enabled = isEmailValid && isPasswordValid
        ) {
            Text(text = "Log in",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 16.sp
            )
        }

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {


            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    color = Color.White,
                    fontStyle = FontStyle.Italic,
                    text = "Forgotten password?",
                    modifier = Modifier.padding(end = 8.dp)
                )
            }

        }
    }

}



//@Composable
//fun Alert(name: String,
//          showDialog: Boolean,
//          onDismiss: () -> Unit) {
//    if (showDialog) {
//        AlertDialog(
//            title = {
//                Text("Title")
//            },
//            text = {
//                Text(text = name)
//            },
//            onDismissRequest = onDismiss,
//            confirmButton = {
//                TextButton(onClick = onDismiss ) {
//                    Text("OK")
//                }
//            },
//            dismissButton = {}
//        )
//    }
//}




//@Composable
//fun AlertDialogView(state: MutableState<Boolean>) {
//    CommonDialog(title = "Alert Dialog", state = state) {
//        Text("JetPack Compose Alert Dialog!")
//    }
//}
//
//@Composable
//fun CommonDialog(
//    title: String?,
//    state: MutableState<Boolean>,
//    content: @Composable (() -> Unit)? = null
//) {
//    AlertDialog(
//        onDismissRequest = {
//            state.value = false
//        },
//        title = title?.let {
//            {
//                Column(
//                    Modifier.fillMaxWidth(),
//                    verticalArrangement = Arrangement.spacedBy(8.dp)
//                ) {
//                    Text(text = title)
//                    Divider(modifier = Modifier.padding(bottom = 8.dp))
//                }
//            }
//        },
//        text = content,
//        dismissButton = {
//            Button(onClick = { state.value = false }) {
//                Text("Cancel")
//            }
//        },
//        confirmButton = {
//            Button(onClick = { state.value = false }) {
//                Text("Ok")
//            }
//        }, modifier = Modifier.padding(vertical = 8.dp)
//    )
//}