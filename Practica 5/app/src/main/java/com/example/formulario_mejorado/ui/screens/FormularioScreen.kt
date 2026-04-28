package com.example.formulario_mejorado.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.formulario_mejorado.model.Usuario
import com.example.formulario_mejorado.utils.Validaciones

@Composable
fun FormularioScreen(modifier: Modifier = Modifier) {

    // 🔹 Estados
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }

    var genero by remember { mutableStateOf("Masculino") }
    var aceptaTerminos by remember { mutableStateOf(false) }
    var activo by remember { mutableStateOf(false) }
    var nivel by remember { mutableStateOf(0f) }

    var resultado by remember { mutableStateOf("") }

    // 🔹 Validaciones usando utils
    val nombreValido = Validaciones.nombreValido(nombre)
    val edadValida = Validaciones.edadValida(edad)
    val correoValido = Validaciones.correoValido(correo)
    val terminosValidos = Validaciones.terminosValidos(aceptaTerminos)

    val formularioValido = nombreValido && edadValida && correoValido && terminosValidos

    Column(modifier = modifier.padding(16.dp)) {

        // 🔹 Nombre
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

        // 🔹 Edad
        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") },
            isError = !edadValida
        )

        if (!edadValida) {
            Text("Edad inválida", color = MaterialTheme.colorScheme.error)
        }

        // 🔹 Correo
        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") },
            isError = !correoValido
        )

        if (!correoValido) {
            Text("Correo inválido", color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // 🔹 Género
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

        // 🔹 Checkbox
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

        // 🔹 Switch
        Row {
            Text("Activo")
            Switch(
                checked = activo,
                onCheckedChange = { activo = it }
            )
        }

        // 🔹 Slider
        Text("Nivel: ${nivel.toInt()}")
        Slider(
            value = nivel,
            onValueChange = { nivel = it },
            valueRange = 0f..10f
        )

        Spacer(modifier = Modifier.height(10.dp))

        // 🔹 Botón Registrar
        Button(
            onClick = {

                val usuario = Usuario(
                    nombre = nombre,
                    edad = edad.toInt(),
                    correo = correo,
                    genero = genero,
                    activo = activo,
                    nivel = nivel.toInt()
                )

                resultado = "Usuario ${usuario.nombre}, ${usuario.edad} años, " +
                        if (usuario.activo) "activo" else "inactivo" +
                                ", nivel ${usuario.nivel}"
            },
            enabled = formularioValido
        ) {
            Text("Registrar")
        }

        Spacer(modifier = Modifier.height(10.dp))

        // 🔹 Botón limpiar
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

        // 🔹 Resultado
        Text(
            text = resultado,
            color = if (formularioValido)
                MaterialTheme.colorScheme.primary
            else
                MaterialTheme.colorScheme.error
        )
    }
}