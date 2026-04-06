package Ejercicio2
class Cuadrado : Shape {

    private var lado: Double = 0.0

    constructor(lado: Double) {
        this.lado = lado
    }

    override fun calcularArea(): Double {
        return lado * lado
    }

    override fun calcularPerimetro(): Double {
        return 4 * lado
    }
}