/**
 * Clase que representa el juego del ahorcado
 */
class Ahorcado(val numIntentos:Int = 5) {
    val consola = GestorConsola()

    private val palabraRandom = Palabra().obtenerPalabraAleatoria() //Palabra random escogida

    fun jugar() {
            println(palabraRandom)
            println(ocultarPalabra())

    }

    private fun ocultarPalabra(){
        val palabraOcultada = mutableListOf<String>()
        val palabraSinOcultar= mutableListOf<String>()

       for (letra in palabraRandom){
           palabraOcultada.add("_")
           palabraSinOcultar.add("$letra")
       }
        consola.mostrarInfo(palabraOcultada.joinToString(" "))

        val letraMetida = consola.pedirCadena("Intenta con una letra: ")



        for (i in 1..palabraSinOcultar.size ){ //Aqui estan los indices peta
            if (letraMetida == palabraSinOcultar[i])
                palabraOcultada[i] = letraMetida
        }


    }
    

}