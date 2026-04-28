package com.example.formulario_mejorado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.formulario_mejorado.ui.screens.FormularioScreen
import com.example.formulario_mejorado.ui.theme.Formulario_MejoradoTheme

/**
 * Descripción: Formulario mejorado en Jetpack Compose con validaciones,
 * componentes interactivos (RadioButton, Checkbox, Switch, Slider),
 * botón inteligente, resumen de datos y opción de limpieza.
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
                    FormularioScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}