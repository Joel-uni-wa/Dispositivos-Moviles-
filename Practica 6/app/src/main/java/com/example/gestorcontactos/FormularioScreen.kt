/*
 * Descripción: Pantalla de formulario para registrar un nuevo contacto; valida que los campos
 *              nombre y teléfono no estén vacíos antes de invocar el callback onGuardar,
 *              y permite cancelar regresando a la lista sin guardar cambios.
 * Autor: Joel Choquepata Guarniz
 * Fecha de creación: 02/05/2026
 * Fecha de última modificación: 02/05/2026
 */

package com.example.gestorcontactos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ── Colores internos del formulario
private val Azul  = Color(0xFF1565C0)
private val Verde = Color(0xFF2E7D32)
private val Rojo  = Color(0xFFE53935)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioScreen(
    onGuardar: (Contacto) -> Unit,
    onCancelar: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var errorNombre by remember { mutableStateOf(false) }
    var errorTelefono by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Nuevo Contacto",
                        fontWeight = FontWeight.Bold,
                        fontSize = 19.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onCancelar) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Azul,
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Text(
                text = "Completa los datos del nuevo contacto",
                fontSize = 15.sp,
                color = Color(0xFF555555)
            )

            HorizontalDivider(color = Color(0xFFBBDEFB), thickness = 1.dp)
            OutlinedTextField(
                value = nombre,
                onValueChange = {
                    nombre = it
                    errorNombre = false
                },
                label = { Text("Nombre completo") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Azul
                    )
                },
                isError = errorNombre,
                supportingText = {
                    if (errorNombre) {
                        Text("El nombre es obligatorio.", color = Rojo, fontSize = 12.sp)
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = telefono,
                onValueChange = {
                    telefono = it
                    errorTelefono = false
                },
                label = { Text("Número de teléfono") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = null,
                        tint = Azul
                    )
                },
                isError = errorTelefono,
                supportingText = {
                    if (errorTelefono) {
                        Text("El teléfono es obligatorio.", color = Rojo, fontSize = 12.sp)
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(6.dp))
            r
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = onCancelar,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Cancelar", color = Azul)
                }

                Button(
                    onClick = {
                        val nombreOk   = nombre.isNotBlank()
                        val telefonoOk = telefono.isNotBlank()
                        errorNombre   = !nombreOk
                        errorTelefono = !telefonoOk

                        if (nombreOk && telefonoOk) {
                            onGuardar(
                                Contacto(
                                    nombre   = nombre.trim(),
                                    telefono = telefono.trim()
                                )
                            )
                        }
                    },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Azul)
                ) {
                    Text("💾 Guardar", color = Color.White)
                }
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("ℹ️", fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "El contacto se agregará al inicio de la lista y podrás marcarlo como favorito.",
                        fontSize = 13.sp,
                        color = Verde
                    )
                }
            }
        }
    }
}
