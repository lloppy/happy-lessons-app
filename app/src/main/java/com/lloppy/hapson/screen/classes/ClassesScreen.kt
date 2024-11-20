package com.lloppy.hapson.screen.classes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lloppy.hapson.repository.ClassModel

sealed class ClassesAction {
    data class OnClassSelected(val classId: String) : ClassesAction()
    data class OnAddNewClass(val classId: String) : ClassesAction()
}


@Composable
fun ClassesScreen(
    onAction: (ClassesAction) -> Unit,
    state: ClassesScreenState
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text = "Список классов", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(16.dp))

        if (state.classModels.isNotEmpty()) {
            LazyColumn {
                items(state.classModels.toList()) { classItem ->
                    ClassItem(classItem) {
                        onAction(ClassesAction.OnClassSelected(classItem.id))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        } else {
            Text(text = "Нет доступных классов")
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = { onAction.invoke(ClassesAction.OnAddNewClass("class" + state.classModels.getLength() + 1 )) }) {
            
        }
    }
}

@Composable
fun ClassItem(classModelItem: ClassModel, onClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().clickable(onClick = onClick)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = classModelItem.name, style = MaterialTheme.typography.titleSmall)
            Text(text = "Преподаватели: ${classModelItem.teachers.joinToString { it.name }}")
            Text(text = "Ученики: ${classModelItem.students.joinToString { it.name }}")
        }
    }
}

@Preview(name = "classes")
@Composable
private fun PreviewClassesScreen() {
    ClassesScreen(
        {}, ClassesScreenState("org1")
    )
}