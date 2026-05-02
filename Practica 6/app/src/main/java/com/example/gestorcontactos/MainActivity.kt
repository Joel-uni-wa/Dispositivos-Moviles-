/*
 * Descripción: Actividad principal que configura el tema, el NavHost y el estado global
 *              de la lista de contactos usando remember (sin ViewModel).
 * Autor: Joel Choquepata Guarniz
 * Fecha de creación: 02/05/2026
 * Fecha de última modificación: 02/05/2026
 */

package com.example.gestorcontactos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gestorcontactos.ui.theme.GestorContactosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GestorContactosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var contactos by remember {
                        mutableStateOf(
                            listOf(
                                Contacto("Ana García",    "987 654 321", favorito = true),
                                Contacto("Carlos López",  "912 345 678"),
                                Contacto("María Torres",  "955 123 456"),
                                Contacto("Juan Pérez",    "944 987 654"),
                                Contacto("Lucía Ríos",    "966 321 789", favorito = true)
                            )
                        )
                    }

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "lista"
                    ) {
                        composable("lista") {
                            ListaScreen(
                                contactos = contactos,

                                onToggleFavorito = { contacto ->
                                    contactos = contactos.map {
                                        if (it == contacto) it.copy(favorito = !it.favorito) else it
                                    }
                                },

                                onEliminar = { contacto ->
                                    contactos = contactos - contacto
                                },
                                navController = navController
                            )
                        }


                        composable("formulario") {
                            FormularioScreen(

                                onGuardar = { nuevoContacto ->
                                    contactos = contactos + nuevoContacto
                                    navController.popBackStack()
                                },

                                onCancelar = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
