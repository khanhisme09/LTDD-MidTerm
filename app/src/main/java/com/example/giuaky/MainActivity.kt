package com.example.giuaky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.giuaky.ui.theme.GiuaKYTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigator()
        }
    }
}


@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    GiuaKYTheme {
        NavHost(navController = navController, startDestination = "signInScreen") {
            composable("signInScreen") {
                SignInScreen(navController = navController)
            }
            composable("signUpScreen") {
                SignUpScreen(navController = navController)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GiuaKYTheme {
    }
}
