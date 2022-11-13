package com.example.circleever.NoticeSection
import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.circleever.ui.theme.SeaGreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NoticeBoardLogin(auth: FirebaseAuth, navController: NavController){
//    Column(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Text(text = "Hello Login First")
//    }



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


                        navController.popBackStack()   // This will directly navigate to Notice Board.

                        navController.navigate(NoticeBoardScreens.AddNoticeWindow.route)

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