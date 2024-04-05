package com.example.giuaky

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun SignInScreen(navController: NavController){
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
            Spacer(modifier = Modifier.padding(30.dp))
        }

        Spacer(modifier = Modifier.padding(50.dp))
        var email by remember { mutableStateOf("") }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Type your Email") },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email") },
            colors = TextFieldDefaults.colors(
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            ),
        )

        Spacer(modifier = Modifier.padding(12.dp))

        var password by remember { mutableStateOf("") }
        var isShowPassword by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Type your Password") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Lock") },
            colors = TextFieldDefaults.colors(
            ),
            trailingIcon = {
                IconButton(onClick = { isShowPassword = !isShowPassword }) {
                    Icon(
                        Icons.Default.Lock,
                        contentDescription = "Show password",
                        tint = if (isShowPassword) Color.Green else Color.Gray
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (isShowPassword) VisualTransformation.None else PasswordVisualTransformation(),
        )

        Spacer(modifier = Modifier.padding(40.dp))

        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()){
            Text(text = "Sign In", color = Color.White)
        }


        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "Not regestered yet? ")
            Text(text = "Sign up!", modifier = Modifier
                .clickable {navController.navigate("signUpScreen")  })
        }
    }
}

