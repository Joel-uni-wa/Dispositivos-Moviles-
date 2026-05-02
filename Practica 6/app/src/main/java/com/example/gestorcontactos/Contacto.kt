/*
 * Descripción: Define el modelo de datos Contacto con nombre, teléfono e indicador de favorito.
 * Autor: Joel Choquepata Guarniz
 * Fecha de creación: 02/05/2026
 * Fecha de última modificación: 02/05/2026
 */

package com.example.gestorcontactos

// Modelo de datos que representa un contacto en la agenda personal
data class Contacto(
    val nombre: String,
    val telefono: String,
    val favorito: Boolean = false
)
