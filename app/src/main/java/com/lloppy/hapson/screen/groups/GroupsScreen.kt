package com.lloppy.hapson.screen.groups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lloppy.hapson.screen.groups.components.DialogMediator

@Composable
fun GroupsScreen() {
    val dialog = remember { DialogMediator() }
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
                // Паттерн Mediator использование пример
                dialog.input.text = newText
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Введите текст") }
        )

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            dialog.okButton.click()
        }) {
            Text("OK")
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            dialog.cancelButton.click()
        }) {
            Text("Cancel")
        }
    }
}