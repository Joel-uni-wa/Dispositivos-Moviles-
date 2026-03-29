fun adivinagame(nran: Int){
    var n: Int //var porque va ir cambiando valores

    for (i in 4 downTo 0){
        println("Ingresa un numero del (1..30)")
        n = readLine()!!.toInt()

        if(n <= 0 || n > 30){ //para que no se salgan de los parametros
            println("numeros invalidos no desperdicies turnos >:C te quedan $i intentos")
            continue
        }else if(n < nran){ //si el numero del usuario es menor
            println("tu numero es menor... te quedan $i intentos")
        }else if(n > nran) { //si el numero del usuario es mayou
            println("Tu numero es mayor... te quedan $i intentos")
        } else { // es igual entonces WIN :D
            println("YOU WIN!!")
            return
        }
    }
    //sale del for entonces ggs
    println("perdiste el numero era: $nran :C")
}
fun main() {
    val nrandom: Int = (1..30).random() // numero random del 1 al 30
    println("Adivina el numero en el que estoy pensando ;D")
    adivinagame(nrandom)

}