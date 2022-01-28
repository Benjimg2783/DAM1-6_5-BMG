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
    val gestorDeLibros = gestionLibros(portatil,interfaz1)
    gestorDeLibros.preguntarPorUnLibro()
    gestorDeLibros.mostrarInfoDeUnLibro()

}
interface CatalogoLibros{
    open fun existeLibro(idLibro:String):Boolean
    open fun infoLibro(idLibro: String): Map<String, Any>
}
interface gestionLibrosIU{
    fun introducirDatos():String
    fun presentarDatos(boolean: Boolean):String
}

class gestionLibrosIU1 :gestionLibrosIU{
    override fun introducirDatos(): String {
        return JOptionPane.showInputDialog("Introduzca el ID:")
    }

    override fun presentarDatos(boolean: Boolean): String {
        return if (boolean) "Este libro existe!"
        else "Este libro no existe!!"
    }
}
class gestionLibrosIU2 :gestionLibrosIU{
    override fun introducirDatos(): String {
        println("Introduzca el ID:")
        return readln()
    }

    override fun presentarDatos(boolean: Boolean): String {
        return if (boolean) "Este libro existe!"
        else "Este libro no existe!!"
    }
}
class gestionLibros(archivo:CatalogoLibros, idLibro: gestionLibrosIU) {
    var cat = archivo
    val id = idLibro
    fun preguntarPorUnLibro() {
        val idLibro= id.introducirDatos()
        if (cat.existeLibro(idLibro))
            println( id.presentarDatos(cat.existeLibro(idLibro)))

        else
            println( id.presentarDatos(cat.existeLibro(idLibro)))
    }

    fun mostrarInfoDeUnLibro() {
        println("Introduzca un ID: ")
        var idLibro = id.introducirDatos()
        var infoLibro = cat.infoLibro(idLibro)
        if (!infoLibro.isEmpty())
            println( infoLibro)
        else
            println("No se encontró información sobre el libro")
    }

}