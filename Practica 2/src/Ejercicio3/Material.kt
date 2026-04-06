package Ejercicio3

abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
}