package Ejercicio2
class Rectangulo : Shape {

    private var base: Double = 0.0
    private var altura: Double = 0.0

    constructor(base: Double, altura: Double) {
        this.base = base
        this.altura = altura
    }

    override fun calcularArea(): Double {
        return base * altura
    }

    override fun calcularPerimetro(): Double {
        return 2 * (base + altura)
    }
}