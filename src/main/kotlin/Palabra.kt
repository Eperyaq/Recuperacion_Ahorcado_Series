import com.google.gson.Gson
import java.io.File
class Palabra {
    companion object{
        const val RUTA_TEXTO = "src/palabras.txt"
        const val RUTA_JSON = "src/palabras.json"
        const val ES_JSON = true

        data class Palabras(val palabras: List<String>)

        fun leerFicheroTexto(ruta: String): List<String> = File(ruta).readLines()

        fun leerFicheroJSON(ruta: String): List<String> {
            val json = File(ruta).readText()
            return Gson().fromJson(json, Palabras::class.java).palabras
        }
    }

    /**
     * Obtiene una palabra aleatoria dependiendo del fichero del que lea
     * @return La palabra aleatoria
     */
    fun obtenerPalabraAleatoria(): String{

        return if (ES_JSON){
            leerFicheroJSON(RUTA_JSON).random()
        } else {
            leerFicheroTexto(RUTA_TEXTO).random()
        }

    }
}