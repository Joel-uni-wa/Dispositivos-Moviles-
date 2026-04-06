package Ejercicio2
class Circulo : Shape {

    private var radio: Double = 0.0

    constructor(radio: Double) {
        this.radio = radio
    }

    override fun calcularArea(): Double {
        return Math.PI * radio * radio
    }

    override fun calcularPerimetro(): Double {
        return 2 * Math.PI * radio
    }
}