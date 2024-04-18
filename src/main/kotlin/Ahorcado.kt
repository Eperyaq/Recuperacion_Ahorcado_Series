/**
 * Clase que representa el juego del ahorcado
 */
class Ahorcado(var numIntentos:Int = 5) {
    val consola = GestorConsola()

    private val palabraRandom = Palabra().obtenerPalabraAleatoria() //Palabra random escogida

    fun jugar() {
            ocultarPalabra()
    }
    private fun ocultarPalabra(){

        var palabraTerminada = false

        val palabraOcultada = mutableListOf<String>() //Lista con la palabra oculta para mostrarla con los _
        val palabraSinOcultar = mutableListOf<String>() //Lista con la palabra sin ocultar para comprobar
        for (letra in palabraRandom) { //Bucle para esconder la palabra y a su vez guardarla en la lista escondida y sin esconder
            palabraOcultada.add("_")
            palabraSinOcultar.add("$letra")
        }
        consola.mostrarInfo(palabraOcultada.joinToString(" "))//Mostrar la palabra ocultada separadas con un espacio

        while (numIntentos > 0 && !palabraTerminada) {

            val letraMetida = consola.pedirCadena("Intenta con una letra: ")

            if (letraMetida in palabraSinOcultar) { //Comprueba si la letra metida está en la lista de la palabra sin ocultar y si es asi la reemplaza en la lista ocultada
                for (i in 0 until palabraSinOcultar.size) {
                    if (letraMetida == palabraSinOcultar[i]) {
                        palabraOcultada[i] = letraMetida
                    }
                }
                consola.mostrarInfo("Correcto!")
                consola.mostrarInfo("Adivina la palabra ${palabraOcultada.joinToString(" ")}")
            } else {
                numIntentos--
                consola.mostrarInfo("Incorrecto!, numero de vidas restantes = $numIntentos")
                consola.mostrarInfo("Adivina la palabra ${palabraOcultada.joinToString(" ")}")
            }

            if ("_" !in palabraOcultada){
                palabraTerminada = true
                consola.mostrarInfo("Felicidades, adivinaste la palabra '$palabraRandom' con $numIntentos numeros de intentos restantes!")
            }
            if (numIntentos == 0) {
                consola.mostrarInfo("Lo siento, Se acabaron tus intentos, la palabra era '$palabraRandom'")
            }
        }
    }
    

}