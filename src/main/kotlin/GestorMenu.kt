class GestorMenu(val consola: IGestorConsola):IMenú {
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

    }

    override fun jugarAhorcado() {
        Ahorcado().jugar()
    }
}