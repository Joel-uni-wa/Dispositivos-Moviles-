package Ejercicio3
//Sistema con materiales y usuarios que permite préstamos y devoluciones.
// Joel Choquepata Guarniz
// Creacion: 2026-04-05
// Edicion: 2026-04-05
fun main() {

    val biblioteca = Biblioteca()

    val usuario1 = Usuario("Juan", "Perez", 20)

    val libro1 = Libro("Kotlin Básico", "Autor A", 2020, "Programación", 300)
    val revista1 = Revista("Tech Today", "Editor B", 2023, "1234-5678", 10, 2, "TechPress")

    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)

    biblioteca.mostrarMaterialesDisponibles()

    println("\n--- Préstamo ---")
    biblioteca.prestarMaterial(usuario1, libro1)

    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesPorUsuario(usuario1)

    println("\n--- Devolución ---")
    biblioteca.devolverMaterial(usuario1, libro1)

    biblioteca.mostrarMaterialesDisponibles()
}