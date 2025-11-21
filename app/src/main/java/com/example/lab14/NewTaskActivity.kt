package com.example.lab14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Activity que simula la vista de Creación de Nueva Tarea.
 */
class NewTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewTaskScreen()
        }
    }
}

@Composable
fun NewTaskScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9)) // Color de fondo claro para diferenciar
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Formulario para Crear Nueva Tarea",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.padding(16.dp)
        )
    }
}