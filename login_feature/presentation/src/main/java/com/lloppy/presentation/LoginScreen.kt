package com.lloppy.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.lloppy.design_system.buttons.HapButton

@Composable
fun LoginScreen(
    onClickLogin: () -> Unit,
    onClickSignIn: () -> Unit
){
    Column {
        HapButton(
            onClick = onClickLogin,
            content = { Text(text = "Войти") }
        )
        HapButton(
            onClick = onClickSignIn,
            content = { Text(text = "Зарегистрироваться") }
        )
    }


}