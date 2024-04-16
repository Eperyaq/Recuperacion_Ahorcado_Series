class GestorConsola:IGestorConsola {

    /**
     * Funcion la cual se encarga de dar una pausa y hasta que no se pulse el enter no pasa, se queda en la pausa
     */
    override  fun pausa() {
        this.pedirCadena("\nPulse una tecla para continuar...")
    }

    /**
     * Funcion la cual muestra un mensaje que sea pasado por parámetros
     * @param mensaje Mensaje o informacion a mostrar
     * @param saltoLinea Un booleano que dependiendo de lo que pongas, tendrá un salto de linea o no
     */
    override fun mostrarInfo(mensaje: String, saltoLinea: Boolean) {
        if (saltoLinea) println(mensaje) else print(mensaje)
    }

    /**
     * Pide un numero entero en un bucle controlando que se meta bien el entero pedido
     * @param mensaje Mensaje personalizado para pedir en entero segun interese
     * @param min Numero minimo
     * @param max Numero maximo
     * @return El numero entero cuando se meta bien el valor
     */
    override fun pedirEntero(mensaje: String, min: Int, max: Int) : Int {
        var numero: Int? = null

        do {
            if (mensaje.isNotBlank()) mostrarInfo(mensaje, false)
            try {
                numero = readln().toInt()
                require(numero in min..max) { "El número debe estar entre $min y $max." }
            }
            catch (e: NumberFormatException) {
                mostrarInfo("**Error** El formato del número es incorrecto.")
            }
            catch (e: IllegalArgumentException) {
                mostrarInfo("**Error** ${e.message}")
            }
        } while (numero == null)

        return numero
    }

    /**
     * Pide un entero pero sin rango de maximo y minimo
     * @param mensaje Mensaje personalizado para pedir el numero
     * @return Retorna el numero introducido por la consola
     */
    override fun pedirEntero(mensaje: String) : Int {
        var numero: Int? = null

        do {
            if (mensaje.isNotBlank()) mostrarInfo(mensaje, false)
            try {
                numero = readln().toInt()
            }
            catch (e: NumberFormatException) {
                mostrarInfo("**Error** El formato del número es incorrecto.")
            }
        } while (numero == null)

        return numero
    }

    /**
     * Pide una cadena y la retorna
     * @param mensaje Mensaje a escribir para pedir lo que necesites
     */
    override fun pedirCadena(mensaje: String): String {
        if (mensaje.isNotBlank()) mostrarInfo(mensaje, false)
        return readln()
    }

    /**
     * Limpia la consola metiendo huecos vacios
     * @param numLineas Numero de lineas a meter para limpiar toda la consola
     */
    override fun limpiar(numLineas: Int) {
        (1..numLineas).forEach { _ -> mostrarInfo("") }
    }


}