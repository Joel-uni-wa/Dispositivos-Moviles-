package com.example.formulario_mejorado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.formulario_mejorado.ui.theme.Formulario_MejoradoTheme

/**
 * Descripción: Formulario mejorado en Jetpack Compose que captura nombre, edad y correo electrónico.
 * Incluye manejo de estado usando remember y componentes básicos de entrada.
 *
 * Fecha: 27/04/2026
 * Autor: Joel Choquepata Guarniz
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Formulario_MejoradoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Formulario(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Formulario(modifier: Modifier = Modifier) {
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )

        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") }
        )

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo electrónico") }
        )
    }
}