package com.example.formulario_mejorado.utils

object Validaciones {

    fun nombreValido(nombre: String) =
        nombre.isNotBlank()

    fun edadValida(edad: String) =
        edad.all { it.isDigit() } && edad.isNotEmpty()

    fun correoValido(correo: String) =
        "@" in correo

    fun terminosValidos(acepta: Boolean) =
        acepta
}