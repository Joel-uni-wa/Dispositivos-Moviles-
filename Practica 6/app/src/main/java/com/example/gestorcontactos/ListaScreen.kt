/*
 * Descripción: Pantalla principal que muestra los contactos en un LazyColumn ordenados con
 *              favoritos primero; permite marcar/desmarcar favoritos, eliminar contactos
 *              y navegar al formulario mediante un FloatingActionButton.
 * Autor: Joel Choquepata Guarniz
 * Fecha de creación: 02/05/2026
 * Fecha de última modificación: 02/05/2026
 */

package com.example.gestorcontactos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// ── Paleta de colores interna de esta pantalla ──────────────────────────────
private val Azul        = Color(0xFF1565C0)
private val AzulClaro   = Color(0xFFE3F2FD)
private val Amarillo    = Color(0xFFFFC107)
private val FondoFav    = Color(0xFFFFF8E1)
private val FondoNormal = Color(0xFFF5F5F5)
private val Rojo        = Color(0xFFE53935)

// Pantalla Lista: muestra contactos ordenados (favoritos primero) con LazyColumn
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaScreen(
    contactos: List<Contacto>,
    onToggleFavorito: (Contacto) -> Unit,
    onEliminar: (Contacto) -> Unit,
    navController: NavController
) {
    val contactosOrdenados = contactos.sortedByDescending { it.favorito }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "📋 Gestor de Contactos",
                            fontWeight = FontWeight.Bold,
                            fontSize = 19.sp
                        )
                        Text(
                            text = "${contactos.size} contacto(s) · ${contactos.count { it.favorito }} favorito(s)",
                            fontSize = 12.sp,
                            color = Color.White.copy(alpha = 0.85f)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Azul,
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("formulario") },
                containerColor = Azul,
                contentColor = Color.White,
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar contacto"
                )
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            if (contactosOrdenados.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("👤", fontSize = 48.sp)
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "No hay contactos registrados.",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                        Text(
                            text = "Presiona ➕ para agregar uno.",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(
                        items = contactosOrdenados,
                        key = { "${it.nombre}_${it.telefono}" }
                    ) { contacto ->
                        // Tarjeta individual para cada contacto
                        ContactoCard(
                            contacto = contacto,
                            onToggleFavorito = { onToggleFavorito(contacto) },
                            onEliminar       = { onEliminar(contacto) }
                        )
                    }
                    item { Spacer(modifier = Modifier.height(72.dp)) }
                }
            }
        }
    }
}

@Composable
private fun ContactoCard(
    contacto: Contacto,
    onToggleFavorito: () -> Unit,
    onEliminar: () -> Unit
) {
    val fondo = if (contacto.favorito) FondoFav else FondoNormal

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = fondo)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(CircleShape)
                    .background(if (contacto.favorito) Amarillo else AzulClaro),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = contacto.nombre.first().uppercaseChar().toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = if (contacto.favorito) Color(0xFF5D4037) else Azul
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = contacto.nombre,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(0xFF1A1A1A)
                )
                Text(
                    text = "📞 ${contacto.telefono}",
                    fontSize = 13.sp,
                    color = Color(0xFF555555)
                )
                if (contacto.favorito) {
                    Text(
                        text = "⭐ Favorito",
                        fontSize = 11.sp,
                        color = Color(0xFF795548),
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            IconButton(onClick = onToggleFavorito) {
                Icon(
                    imageVector = if (contacto.favorito) Icons.Filled.Star else Icons.Outlined.Star,
                    contentDescription = if (contacto.favorito) "Quitar de favoritos" else "Marcar como favorito",
                    tint = if (contacto.favorito) Amarillo else Color.Gray,
                    modifier = Modifier.size(26.dp)
                )
            }

            IconButton(onClick = onEliminar) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar contacto",
                    tint = Rojo,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
