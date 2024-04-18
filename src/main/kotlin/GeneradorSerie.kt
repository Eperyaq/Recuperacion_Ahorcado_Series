import kotlin.random.Random
import kotlin.random.nextInt

object GeneradorSerie {
    const val MIN = 1
    const val MAX = 100
    val consola = GestorConsola()

    val numero1 = Random.nextInt(MIN..70)
    val numero2 = Random.nextInt(numero1 + 30..MAX)

    /**
     * Genera un rango de numeros aleatorios y le pregunta al usuario que escoja uno
     * @return Int el numero escogido por el usuario dentro de ese rango
     */
    fun generarRangoAleatorio():Int {

        val rango = mutableListOf<Int>()

        rango.add(numero1)
        rango.add(numero2)

        val numeroSacado = consola.pedirEntero("Inserte un numero $rango: ", numero1, numero2)

        return numeroSacado
    }

    /**
     * Funcion que dependiendo del numero que introduzca el usuario llamará a una o a otra funcion
     */
    fun generarSerie() {

        var serieTerminada = false

        do {

            val numeroElegido = generarRangoAleatorio()
            val numeroMid = (numero1 + numero2) /2

            if (numeroElegido < numeroMid) {
                serieTerminada = true
                generarSerieDecreciente(numeroElegido)

            } else if (numeroElegido > numeroMid) {
                serieTerminada = true
                generarSerieCreciente(numeroElegido)

            }
        } while (!serieTerminada)
    }
    /**
     * Funcion que crea una serie de numeros creciente y al final te muestra la suma total de numeros
     * @param numero Numero que ha introducido el usuario
     */
    fun generarSerieCreciente(numero: Int){
        var total = 0
        var suma = 0

        for (i in 0 until (numero2 - numero + 1)) {
            for (j in 0..i) {
                val num = numero + j
                suma += num
                consola.mostrarInfo("$num", false)
                if (j < i) {
                    consola.mostrarInfo("+", false)
                }
            }
            consola.mostrarInfo(" ($i)")
            total += suma
        }
        consola.mostrarInfo("Suma => $total")
    }

    /**
     * Funcion que crea una serie de numeros decreciente y al final te muestra la suma total de numeros
     * @param numero Numero que ha introducido el usuario
     */
    fun generarSerieDecreciente(numero: Int){
        var contador = 1
        var total = 0
        var suma = 0

        for (i in numero downTo numero1) {
            consola.mostrarInfo("$contador -> ", false) //muestra el numero de la fila
            for (j in numero downTo i) { //Desde el numero introducido por el usuario hasta i que es desde el numero del usuario hasta el numero mas pequeño del rango
                suma += j
                consola.mostrarInfo("$j", false)
                if (j > i) {
                    consola.mostrarInfo("+", false)
                }
            }
            contador++
            consola.mostrarInfo(" = $suma")
            total += suma
        }
        consola.mostrarInfo("Total => $total")
    }

}