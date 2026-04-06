package Ejercicio3
class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {

    override fun mostrarDetalles() {
        println("Revista: $titulo, ISSN: $issn, Vol: $volumen, Nº: $numero, Editorial: $editorial")
    }
}