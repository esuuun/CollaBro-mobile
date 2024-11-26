package com.example.collabro.ui.screen

import android.widget.MediaController
import androidx.compose.foundation.Image
import com.example.collabro.R.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.border
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.max
import androidx.navigation.NavController
import com.example.collabro.R
import com.example.collabro.ui.screen.*
import com.example.collabro.ui.screen.components.ForgetPassword
import com.example.collabro.ui.screen.components.Google
import com.example.collabro.ui.screen.components.MatchItem
import com.example.collabro.ui.screen.components.Or
import com.example.collabro.ui.theme.Primary


@Composable
fun LoginScreen(navController: NavController){
    var email by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = Color.Transparent
            ) { paddings ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddings)
                        .padding(
                            horizontal = 24.dp,
                            vertical = 24.dp
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        "Hey,Welcome Back",
                        fontSize = 46.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Primary,
                        lineHeight = 50.sp
                    )
                    Spacer(modifier = Modifier.height(100.dp))

                    Text("Email", color = Color.Black, fontSize = 12.sp, lineHeight = 30.sp)
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Normal,), placeholder = { Text("Lesun@gmail.com") })
                    Spacer(modifier = Modifier.height(20.dp))

                    Text("Password", color = Color.Black, fontSize = 12.sp, lineHeight = 30.sp)
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        Modifier.fillMaxWidth(),
                        textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        placeholder = { Text("********") },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    ForgetPassword()
                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {navController.navigate(Route.homeScreen)},
                        Modifier.fillMaxWidth().padding(horizontal = 20.dp).height(40.dp),
                        colors = ButtonDefaults.buttonColors(Primary),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(text = "LogIn", fontWeight = FontWeight.Bold, color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    Or()

                    Spacer(modifier = Modifier.height(20.dp))

                    Google()


                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "Don’t have an account?",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                lineHeight = 30.sp
                            )
                            TextButton(onClick = { navController.navigate(Route.signIn)}) {
                                Text(
                                    "Sign In",
                                    color = Color.Green,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }

        }
    }
}