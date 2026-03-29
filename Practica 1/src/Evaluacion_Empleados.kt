//funcion para poder calcular el rendimiento y dinero que recibira el empelado
fun calcularRendimiento( pun:Int ,sal:Double){
    //definicion de variables
    val dinero: Double = sal * (pun/10.0) //inmutable porque no se modificara
    var rendimiento: String ="" //string para poder guardar el rendimiento de cada empleado

    when(pun) {
        in 0 .. 3 -> rendimiento = "Inaceptable"
        in 4 .. 6 -> rendimiento = "Aceptable"
        in 7 ..10 -> rendimiento = "Meritorio"
    }

    println("nivel de rendimiento: $rendimiento")
    println("Cantidad de dinero: $dinero")
}
fun main() {
    //Creacion de variables
    val salario: Double
    val puntuacion: Int

    println("ingrese su salario")
    salario = readLine()!!.toDouble() // para poder ingresar valores Double

    println("Ingrese su puntuación")
    puntuacion = readLine()!!.toInt() // para poder ingresar valores Int

    calcularRendimiento(puntuacion, salario)
}