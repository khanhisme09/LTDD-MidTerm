package com.example.giuaky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import com.example.giuaky.ui.theme.GiuaKYTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GiuaKYTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val isHomeScreen = remember { mutableStateOf(true) }

                    if (isHomeScreen.value) {
                        HomeScreen { isHomeScreen.value = false }
                    } else {
                        UpScreen { isHomeScreen.value = true }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(onChangeClick: () -> Unit) {
    Column() {
        Column(
            modifier = Modifier
                .background(
                    Color.Yellow,
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = 100.dp,
                        bottomStart = 30.dp
                    )
                )
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Welcome,",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Black,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp))
            Text(text = "Sign In to continue",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Black,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp))
            TheSpacer()
            TheSpacer()
            TheSpacer()
        }
        Column(modifier = Modifier.padding(top= 100.dp)) {
            InputEmail()
            TheSpacer()
            InputPassword()
            TheSpacer()
            //RetypeInputPassword()
            TheSpacer()
            TheSpacer()
            TheSpacer()
            TheSpacer()
            SignInButton()
            TheSpacer()
            Change(onClick = onChangeClick)
        }
    }
}

@Composable
fun UpScreen(onChangeClick: () -> Unit) {
    Column() {
        Column(
            modifier = Modifier
                .background(
                    Color.Yellow,
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = 100.dp,
                        bottomStart = 30.dp
                    )
                )
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Welcome,",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Black,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp))
            Text(text = "Sign Up to continue",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Black,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp))
            TheSpacer()
            TheSpacer()
            TheSpacer()
        }
        Column(modifier = Modifier.padding(top= 100.dp)) {
            InputEmail()
            TheSpacer()
            InputPassword()
            TheSpacer()
            RetypeInputPassword()
            TheSpacer()
            TheSpacer()
            TheSpacer()
            Column {
                TheSpacer()
                SignInButton()
                TheSpacer()
                Change(onClick = onChangeClick)
            }
        }
    }

}


@Composable
fun TheSpacer() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GiuaKYTheme {
        //HomeScreen()
    }
}
