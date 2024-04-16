/**
 * Clase que representa el juego del ahorcado
 */
class Ahorcado(val numIntentos:Int = 5) {
    val consola = GestorConsola()

    private val palabraRandom = Palabra().obtenerPalabraAleatoria() //Palabra random escogida

    fun jugar() {
        while (true) {
            println(palabraRandom)
            println(ocultarPalabra())
            buscarPalabra()
        }


    }

    private fun ocultarPalabra(){
        val palabraOcultada = mutableListOf<String>()
        val palabraSinOcultar= mutableListOf<String>()

       for (letra in palabraRandom){
           palabraOcultada.add("_")
           palabraSinOcultar.add("$letra")
       }
        palabraOcultada.joinToString(" ")

        val letraMetida = consola.pedirCadena("Intenta con una letra: ")

        if (letraMetida in palabraSinOcultar){
            palabraOcultada.size
        }

    }

    private fun buscarPalabra(){

        val letras = mutableListOf<String>()

        for (letra in palabraRandom){
            letras.add("$letra")
        }


    }

}