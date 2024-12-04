package com.lloppy.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lloppy.presentation.data.Course
import com.lloppy.presentation.repository.CoursesRepository
import com.lloppy.presentation.strategy.FilterManager
import com.lloppy.presentation.strategy.NameFilter
import com.lloppy.presentation.strategy.OrganizationFilter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesSearch() {
    val originalCourses = CoursesRepository.getOrganizations().flatMap { it.courses }
    val organizations = CoursesRepository.getOrganizations()

    var searchQuery by remember { mutableStateOf("") }
    var filteredCourses by remember { mutableStateOf(originalCourses) }

    var selectedOrganizationId by remember { mutableStateOf<String?>(null) }
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it

                // Паттерн State
                val nameFilter = NameFilter(searchQuery)
                val organizationFilter = OrganizationFilter(selectedOrganizationId)

                val filterManager = FilterManager()
                filteredCourses = filterManager.applyFilters(
                    listOf(nameFilter, organizationFilter),
                    originalCourses
                )
            },
            label = { Text("Поиск курсов") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
            TextField(
                readOnly = true,
                value = selectedOrganizationId?.let { id ->
                    organizations.find { it.id == id }?.name ?: "Выберите организацию"
                } ?: "Выберите организацию",
                onValueChange = {},
                label = { Text("Организация") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier.fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxSize()
            ) {
                organizations.forEach { organization ->
                    DropdownMenuItem(
                        text = {Text(text = organization.name)},
                        onClick = {
                        selectedOrganizationId = organization.id
                        expanded = false

                        val nameFilter = NameFilter(searchQuery)
                        val organizationFilter = OrganizationFilter(selectedOrganizationId)

                        val filterManager = FilterManager()
                        filteredCourses = filterManager.applyFilters(
                            listOf(nameFilter, organizationFilter),
                            originalCourses
                        )
                    })
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(filteredCourses) { course ->
                Text(text = course.name)
            }
        }
    }
}