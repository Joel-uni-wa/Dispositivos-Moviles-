import Ejercicio1.Producto
fun main() {
    val producto = Producto()

    producto.setPrecio(122.0)
    producto.setDescuento(20.0)

    println("Precio: ${producto.getPrecio()}")
    println("Descuento: ${producto.getDescuento()}%")
    println("Precio final: ${producto.calcularPrecioFinal()}")
}