//Cree funciones para poder probar lo de su simplificacion (me complico solo XD)
fun suma(n1: Int, n2: Int): Int = n1 + n2
fun resta(n1: Int, n2: Int): Int = n1 - n2
fun multi(n1: Int, n2: Int): Int = n1 * n2
fun division(n1: Int, n2: Int): Int = n1 / n2

//dependiendo de la opcion llama a su funcion correspondiente con los numeros ingresados
fun calculadora(op: String, n1: Int, n2: Int){
    when {
        op.lowercase() == "suma" -> println(suma(n1, n2)) //uso lowercase por lo de las mayusculas
        op.lowercase() == "resta" -> println(resta(n1, n2))
        op.lowercase() == "division" -> println(division(n1, n2))
        op.lowercase() == "multiplicacion" -> println(multi(n1, n2))
        else -> println("ERROR opcion invalida")
    }
}

fun main(){
    println("====Menu====")
    println("||  Suma  ||")
    println("||  Resta  ||")
    println("||  Multiplicacion  ||")
    println("||  Division  ||")
    println("||  Salir  ||")

    val opcion: String = readLine()!!.toString()

    if(opcion.lowercase() == "salir"){ //por si decide salir de una terminar el proceso B)
        println("nos vemos pronto :)...")
        return
    }
    println("ingrese el 1° numero...")
    val num1 = readLine()!!.toInt() //valor 1
    println("ingrese el 2° numero...")
    val num2 = readLine()!!.toInt()//valor 2
    calculadora(opcion, num1, num2)
}