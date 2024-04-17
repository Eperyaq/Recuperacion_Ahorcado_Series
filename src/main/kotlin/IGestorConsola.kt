interface IGestorConsola {

    fun pausa()

    fun mostrarInfo(mensaje: String = "", saltoLinea: Boolean = true)

    fun pedirEntero(mensaje: String = "", min: Int, max: Int) : Int

    fun pedirEntero(mensaje: String = "") : Int

    fun pedirCadena(mensaje: String = "") : String

    fun limpiar(numLineas: Int = 20)


}