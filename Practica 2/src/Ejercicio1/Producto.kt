package Ejercicio1
//lase para Producto: Diseña una clase Producto que tenga un precio y un descuento aplicable implementando métodos set y get para establecer y obtener el precio y el descuento
// Joel Choquepata Guarniz
// Creacion: 2026-04-03
// Edicion: 2026-04-05
class Producto {

    private var precio: Double = 0.0
    private var descuento: Double = 0.0  // porcentaje (0 a 100)

    // SET y GET de precio
    fun setPrecio(valor: Double) {
        if (valor >= 0) {
            precio = valor
        } else {
            println("El precio no puede ser negativo")
        }
    }

    fun getPrecio(): Double {
        return precio
    }

    // SET y GET de descuento
    fun setDescuento(valor: Double) {
        if (valor in 0.0..100.0) {
            descuento = valor
        } else {
            println("El descuento debe estar entre 0 y 100")
        }
    }

    fun getDescuento(): Double {
        return descuento
    }

    // Método para calcular precio final
    fun calcularPrecioFinal(): Double {
        return precio - (precio * descuento / 100)
    }
}