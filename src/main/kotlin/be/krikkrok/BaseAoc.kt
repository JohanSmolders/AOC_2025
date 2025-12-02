package be.krikkrok

import java.io.File
import java.io.Reader
import java.net.URL
import java.nio.charset.StandardCharsets
import java.util.*

abstract class BaseAoc {
    fun asString(location: String): String = String(BaseAoc::class.java.getResourceAsStream(location).readAllBytes(), StandardCharsets.UTF_8);

    fun asReader(location: String): Reader = BaseAoc::class.java.getResourceAsStream(location).reader()
    fun asStringList(location: String): LinkedList<String> {
        val linkedList = LinkedList<String>()
        asReader(location).forEachLine {
            linkedList.add(it)
        }
        return linkedList
    }

    fun asIntList(location: String) = asStringList(location).map { it.toInt() }

    fun asResource(location: String): URL = BaseAoc::class.java.getResource(location)

    fun getTestFile() = "test.txt"
    abstract fun getRealFile(): String
    abstract fun runTest(): Boolean
    abstract fun getFolder(): String

    fun getFile(): String {
        return if(runTest()){
            "${File.separator}${getFolder()}${File.separator}${getTestFile()}"
        }else "${File.separator}${getFolder()}${File.separator}${getRealFile()}"
    }

    fun printResult(string: String) {
        val green = "\u001B[33m"
        println("$green$string")
        val reset = "\u001B[0m"
        print(reset)
    }
}