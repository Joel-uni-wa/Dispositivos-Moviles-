package com.example.formulario_mejorado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                    Formulario(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Formulario(modifier: Modifier = Modifier) {

    // Estados
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }

    var genero by remember { mutableStateOf("Masculino") }
    var aceptaTerminos by remember { mutableStateOf(false) }
    var activo by remember { mutableStateOf(false) }
    var nivel by remember { mutableStateOf(0f) }

    var resultado by remember { mutableStateOf("") }

    // Validaciones
    val nombreValido = nombre.isNotBlank()
    val edadValida = edad.all { it.isDigit() } && edad.isNotEmpty()
    val correoValido = "@" in correo
    val terminosValidos = aceptaTerminos

    val formularioValido = nombreValido && edadValida && correoValido && terminosValidos

    Column(modifier = modifier.padding(16.dp)) {

        // Nombre
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            isError = !nombreValido
        )

        Text("Caracteres: ${nombre.length}")

        if (!nombreValido) {
            Text("El nombre no puede estar vacío", color = MaterialTheme.colorScheme.error)
        }

        // Edad
        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") },
            isError = !edadValida
        )

        if (!edadValida) {
            Text("La edad debe ser numérica", color = MaterialTheme.colorScheme.error)
        }

        // Correo
        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo electrónico") },
            isError = !correoValido
        )

        if (!correoValido) {
            Text("Correo inválido (debe contener @)", color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // RadioButton
        Text("Género")
        Row {
            RadioButton(
                selected = genero == "Masculino",
                onClick = { genero = "Masculino" }
            )
            Text("Masculino")

            Spacer(modifier = Modifier.width(10.dp))

            RadioButton(
                selected = genero == "Femenino",
                onClick = { genero = "Femenino" }
            )
            Text("Femenino")
        }

        // Checkbox
        Row {
            Checkbox(
                checked = aceptaTerminos,
                onCheckedChange = { aceptaTerminos = it }
            )
            Text("Aceptar términos")
        }

        if (!terminosValidos) {
            Text("Debes aceptar los términos", color = MaterialTheme.colorScheme.error)
        }

        // Switch
        Row {
            Text("Activo")
            Switch(
                checked = activo,
                onCheckedChange = { activo = it }
            )
        }

        // Slider
        Text("Nivel: ${nivel.toInt()}")
        Slider(
            value = nivel,
            onValueChange = { nivel = it },
            valueRange = 0f..10f
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Botón Registrar
        Button(
            onClick = {
                resultado = "Usuario $nombre, ${edad} años, " +
                        if (activo) "activo" else "inactivo" +
                                ", nivel ${nivel.toInt()}"
            },
            enabled = formularioValido
        ) {
            Text("Registrar")
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Botón Limpiar
        Button(
            onClick = {
                nombre = ""
                edad = ""
                correo = ""
                genero = "Masculino"
                aceptaTerminos = false
                activo = false
                nivel = 0f
                resultado = ""
            }
        ) {
            Text("Limpiar")
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Resultado colores xd
        Text(
            text = resultado,
            color = if (formularioValido) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.error
        )
    }
}
