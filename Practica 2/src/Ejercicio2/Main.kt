package Ejercicio2
import Ejercicio2.Shape
import Ejercicio2.Cuadrado
import Ejercicio2.Circulo
import Ejercicio2.Rectangulo
fun main() {

    val cuadrado = Cuadrado(4.0)
    val circulo = Circulo(3.0)
    val rectangulo = Rectangulo(5.0, 2.0)

    println("Cuadrado:")
    cuadrado.imprimirResultados()

    println("\nCírculo:")
    circulo.imprimirResultados()

    println("\nRectángulo:")
    rectangulo.imprimirResultados()
}