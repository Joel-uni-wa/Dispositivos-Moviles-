//Funcion para saber que eligieron los jugadores
fun nombreJugada(j: Int): String = when (j) {
    1 -> "Piedra"
    2 -> "Papel"
    3 -> "Tijera"
    else -> "Opcion invalida"
}
//El juego en general con comparaciones para saber quien gano
fun game(j1: Int, jcpu: Int) {
    val resultado = when {
        j1 == jcpu -> "DRAW"

        j1 == 1 && jcpu == 2 -> "CPU WINS!"
        j1 == 1 && jcpu == 3 -> "PLAYER WINS!"

        j1 == 2 && jcpu == 1 -> "PLAYER WINS!"
        j1 == 2 && jcpu == 3 -> "CPU WINS!"

        j1 == 3 && jcpu == 1 -> "CPU WINS!"
        j1 == 3 && jcpu == 2 -> "Player WINS!"

        else -> "Jugada invalida"
    }

    println("Player: ${nombreJugada(j1)} || CPU: ${nombreJugada(jcpu)} || $resultado")
}
fun main() {
    val cpu: Int = (1..3).random() //la CPU saca un numero random de 1 a 3
    val jugador: Int
    println("Ingresa tu jugada: 1 = piedra | 2 = papel | 3 = tijera")

    jugador = readLine()!!.toInt() //El jugador elige una opcion

    game(jugador, cpu)
}