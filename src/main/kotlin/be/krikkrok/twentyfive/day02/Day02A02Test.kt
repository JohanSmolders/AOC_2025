package be.krikkrok.twentyfive.day02

import be.krikkrok.BaseAoc

class Day02A02Test : BaseAoc() {
    init {
        val input = asString(getFile())
        var answer: Long = 0

        input.split(",").forEach { product ->
            val ids = product.split("-")
            val range = ProductIdRange(ids[0].toLong(), ids[1].toLong())

            (range.firstId..range.secondId).forEach { id ->
                val currentId = id.toString()
                for (i in currentId.length downTo 2) {
                    val parts = splitIntoParts(currentId, i)
                    if (parts?.distinct()?.size == 1) {
                        answer += currentId.toLong()
                        break
                    }
                }
            }
        }

        printResult("$answer")

    }

    fun splitIntoParts(s: String, parts: Int): List<String>? {
        if (s.length % parts != 0) return null

        val size = s.length / parts
        return s.chunked(size)
    }

    override fun getRealFile(): String {
        return "a01.txt"
    }

    override fun runTest(): Boolean {
        return false
    }

    override fun getFolder(): String {
        return "day02"
    }
}

fun main(args: Array<String>) {
    Day02A02Test()
}