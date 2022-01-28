package un6.eje6_5

import java.util.logging.Level
import java.util.logging.LogManager
import javax.swing.JOptionPane

internal val l = LogManager.getLogManager().getLogger("").apply { level = Level.ALL }
internal fun i(tag: String, msg: String) {
    l.info("[$tag] - $msg")
}


fun main() {
    val interfaz1=gestionLibrosIU1()
    var portatil = CatalogoLibrosXML("C:\\Users\\Benjamin\\IdeaProjects\\DAM1-6_5-BMG\\src\\main\\kotlin\\catalog.xml")
    //var casa = "/home/usuario/Documentos/workspace/IdeaProjects/IESRA-DAM/ejercicios/src/main/kotlin/un5/eje5_4/Catalog.xml"
    val gestorDeLibros = catalogoLibros(portatil,interfaz1)
    gestorDeLibros.preguntarPorUnLibro()
    gestorDeLibros.mostrarInfoDeUnLibro()

}
interface CatalogoLibros{
    fun existeLibro(idLibro:String):Boolean
    fun infoLibro(idLibro: String): Map<String, Any>
}
interface gestionLibrosIU{
    fun introducirId():String
    fun existeLibro(boolean: Boolean):String
}

class gestionLibrosIU1 :gestionLibrosIU{
    override fun introducirId(): String {
        return JOptionPane.showInputDialog("Introduzca el ID:")
    }

    override fun existeLibro(boolean: Boolean): String {
        return if (boolean) "Este libro existe!"
        else "Este libro no existe!!"
    }
}
class gestionLibrosIU2 :gestionLibrosIU{
    override fun introducirId(): String {
        println("Introduzca el ID:")
        return readln()
    }

    override fun existeLibro(boolean: Boolean): String {
        return if (boolean) "Este libro existe!"
        else "Este libro no existe!!"
    }
}
class catalogoLibros(archivo:CatalogoLibros, idLibro: gestionLibrosIU) {
    var cat = archivo
    val id = idLibro
    fun preguntarPorUnLibro() {
        val idLibro= id.introducirId()
        if (cat.existeLibro(idLibro))
            println( id.existeLibro(cat.existeLibro(idLibro)))

        else
            println( id.existeLibro(cat.existeLibro(idLibro)))
    }

    fun mostrarInfoDeUnLibro() {
        var idLibro = id.introducirId()
        var infoLibro = cat.infoLibro(idLibro)
        if (!infoLibro.isEmpty())
            println( infoLibro)
        else
            println("No se encontró información sobre el libro")
    }

}