package Ejercicio3
class Biblioteca : IBiblioteca {

    private val materialesDisponibles = mutableListOf<Material>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        prestamos[usuario] = mutableListOf()
    }

    override fun prestarMaterial(usuario: Usuario, material: Material) {
        if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material)
            prestamos[usuario]?.add(material)
            println("Préstamo realizado: ${material.titulo}")
        } else {
            println("Material no disponible")
        }
    }

    override fun devolverMaterial(usuario: Usuario, material: Material) {
        if (prestamos[usuario]?.contains(material) == true) {
            prestamos[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("Material devuelto: ${material.titulo}")
        } else {
            println("El usuario no tiene este material")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesPorUsuario(usuario: Usuario) {
        println("Materiales de ${usuario.nombre}:")
        prestamos[usuario]?.forEach { it.mostrarDetalles() }
    }
}