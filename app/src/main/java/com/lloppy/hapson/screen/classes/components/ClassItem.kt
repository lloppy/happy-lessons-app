package com.lloppy.hapson.screen.classes.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lloppy.hapson.course_feature.data.Course

@Composable
fun ClassItem(courseItem: Course, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = courseItem.name, style = MaterialTheme.typography.titleSmall)
            Text(text = "Преподаватели: ${courseItem.teachers.joinToString { it.name }}")
            Text(text = "Ученики: ${courseItem.students.joinToString { it.name }}")
        }
    }
}