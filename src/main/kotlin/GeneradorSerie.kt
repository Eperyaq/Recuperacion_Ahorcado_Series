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


        for (i in 0 until (numero2 - numero + 1)) {
            var suma = 0
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
    /*
     *Explicacion de generarSerieCreciente
     *
     * se crea la variable total para la suma total
     * numero2- numero +1 es para determinar la cantidad de lineas que va a tener la serie
     * se crea la variable suma para hacer las sumas en el momento y mandarsela a total
     * el segundo for itera entre 0 e i que i es el numero de lineas de la serie
     * declara la variable num que es la suma de los numeros que hayan salido
     */

    /**
     * Funcion que crea una serie de numeros decreciente y al final te muestra la suma total de numeros
     * @param numero Numero que ha introducido el usuario
     */
    fun generarSerieDecreciente(numero: Int){
        var contador = 1 //Contador de las filas
        var total = 0 //Suma total total total


        for (i in numero downTo numero1) {
            var suma = 0
            consola.mostrarInfo("$contador -> ", false)
            for (j in numero downTo i) {
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

    /*
     *Explicacion generar Serie creciente
     * se incializan las variables
     * contador, para el contador de las filas
     * total, para el total de la suma final
     *
     * primer for
     * for (i in numero downTo numero1) -> para i que va a ser un valor en numero(numero escogido por el jugador) hasta numero1(numero random que haya salido en el rango) va a iterar
     * y cada iteracion va a ir bajandole 1
     *
     * se crea la variable suma para ir añadiendo los numeros que se recojan en el segundo bucle for hace la suma de estos,y lo manda a total que es la suma total.
     * se muestra la primera fila con el contador
     *
     * segundo for
     * for (j in numero downTo i) -> para J que va a ser el valor del numero hasta i que va a ir decrementando tambien
     * se añade el valor de este a la suma tantas veces como se itere por J, tantos numeros hayan
     * Y se comprueba si es el ultimo, si lo es, no hace nada, si no lo es, añade un +
     *
     * suma 1 al contador
     * dentro del primer for aun, muestra la suma de los numeros que se hayan añadido
     * y al final del to do muestra el total con la suma total

     */

        var resul = " "
        var cont = 1
        while (num>= min){
            resul += "${cont.toString().padStart(2,'0')} => "
            resul += (num downTo min).joinToString("+") + " = "
            total = (min..num).sumOf{it}
            res += total.toString + "\n"
        }
        resul


}