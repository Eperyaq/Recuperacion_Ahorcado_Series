class GestorMenu(private val consola: IGestorConsola):IMenú {
    override fun mostrarMenu() {
        consola.mostrarInfo("Que desea hacer? \n1.- Generar serie. \n2.- Jugar al ahorcado \n3.- Salir")
        val opcion = consola.pedirEntero("Por favor, seleccione una opcion: ",1,3)

        when (opcion){
            1-> generarSerie()
            2-> jugarAhorcado()
            3-> consola.mostrarInfo("Saliendo...")
        }
    }

    override fun generarSerie() {
        GeneradorSerie.generarSerie() //Se hace asi porque es un object no hace falta instanciar
    }

    override fun jugarAhorcado() {
        Ahorcado(consola).jugar() //Instancia unica y momentánea del ahorcado sin crear variable.
    }
}