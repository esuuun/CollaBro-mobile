package com.example.collabro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.collabro.ui.screen.HomeScreen
import com.example.collabro.ui.theme.CollaBroTheme
import com.example.collabro.ui.screen.LoginScreen
import com.example.collabro.ui.screen.NotificationScreen
import com.example.collabro.ui.screen.Route
import com.example.collabro.ui.screen.SignIn
import kotlinx.coroutines.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { true }

        CoroutineScope(Dispatchers.Main).launch() {
            delay(3000L)
            splashScreen.setKeepOnScreenCondition { false }
        }

        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "login") {
                composable(Route.loginScreen) {
                    LoginScreen(navController)
                }
                composable(Route.signIn) {
                    SignIn(navController)
                }
                composable(Route.homeScreen) {
                    HomeScreen()
                }
//            CollaBroTheme {
////                HomeScreen()
////                LoginScreen();
////                SignIn()
//                NotificationScreen(navController = navController)
//            }
            }
        }
    }
}
