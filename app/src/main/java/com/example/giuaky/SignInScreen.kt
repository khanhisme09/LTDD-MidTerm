package com.example.giuaky

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun InputEmail(){
    var email by remember { mutableStateOf("") }
    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Email") },
        placeholder = { Text(text = "Type your Email") },
        leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email") },
        colors = TextFieldDefaults.colors(
            //focusedIndicatorColor = Color.Transparent,
            //unfocusedIndicatorColor = Color.Transparent,
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ),
    )
}

@Composable
fun InputPassword(){
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
            //focusedIndicatorColor = Color.Transparent,
            //unfocusedIndicatorColor = Color.Transparent,
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
}




@Composable
fun SignInButton(){
    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()){
        Text(text = "Sign In", color = Color.White)
    }
}

@Composable
fun Change(onClick: () -> Unit){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center) {
        Text(text = "Not regestered yet? ")
        Text(text = "Sign up!", modifier = Modifier
            .clickable {onClick() })
    }
}