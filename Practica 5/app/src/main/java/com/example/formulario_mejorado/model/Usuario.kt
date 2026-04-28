package com.example.formulario_mejorado.model

data class Usuario(
    val nombre: String,
    val edad: Int,
    val correo: String,
    val genero: String,
    val activo: Boolean,
    val nivel: Int
)