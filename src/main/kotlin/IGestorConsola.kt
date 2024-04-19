interface IGestorConsola {

    /**
     * Funcion la cual muestra un mensaje que sea pasado por parámetros
     * @param mensaje Mensaje o informacion a mostrar
     * @param saltoLinea Un booleano que dependiendo de lo que pongas, tendrá un salto de linea o no
     */
    fun mostrarInfo(mensaje: String = "", saltoLinea: Boolean = true)

    /**
     * Pide un numero entero en un bucle controlando que se meta bien el entero pedido
     * @param mensaje Mensaje personalizado para pedir en entero segun interese
     * @param min Numero minimo
     * @param max Numero maximo
     * @return El numero entero cuando se meta bien el valor
     */
    fun pedirEntero(mensaje: String = "", min: Int, max: Int) : Int

    /**
     * Pide un entero pero sin rango de maximo y minimo
     * @param mensaje Mensaje personalizado para pedir el numero
     * @return Retorna el numero introducido por la consola
     */
    fun pedirEntero(mensaje: String = "") : Int

    /**
     * Pide una cadena y la retorna
     * @param mensaje Mensaje a escribir para pedir lo que necesites
     */
    fun pedirCadena(mensaje: String = "") : String



}