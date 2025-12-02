package be.krikkrok.twentyfive.day03

import be.krikkrok.BaseAoc

class Day03A01Test : BaseAoc() {
    override fun timedFun()  {
        asString(getFile())
        var answer: Long = 0


        printResult("$answer")
    }


    override fun getRealFile(): String {
        return "a01.txt"
    }

    override fun runTest(): Boolean {
        return true
    }

    override fun getFolder(): String {
        return "day03"
    }
}

fun main() {
    Day03A01Test()
}