package com.lloppy.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lloppy.design_system.buttons.HapButton
import com.lloppy.design_system.text.HapText

@Composable
fun LoginScreen(
    onClickLogin: () -> Unit,
    onClickSignIn: () -> Unit,
    onClickOrgLogin: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HapButton(
            onClick = onClickLogin,
            modifier = Modifier.fillMaxWidth(),
            content = { Text(text = "Войти") }
        )
        HapButton(
            onClick = onClickSignIn,
            modifier = Modifier.fillMaxWidth(),
            content = { Text(text = "Зарегистрироваться") }
        )
        HapText(
            text = "войти как организация",
            modifier = Modifier.align(Alignment.End),
            onClick = onClickOrgLogin

        )
    }
}