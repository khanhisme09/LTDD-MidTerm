package com.example.giuaky

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
fun RetypeInputPassword(){
    var passwordAgain by remember { mutableStateOf("") }
    var isShowPassword by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = passwordAgain,
        onValueChange = { passwordAgain = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Retype Password") },
        placeholder = { Text(text = "Retype your Password") },
        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Lock") },
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


