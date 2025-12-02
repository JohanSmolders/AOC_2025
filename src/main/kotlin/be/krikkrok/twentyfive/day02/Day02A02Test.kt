package be.krikkrok.twentyfive.day02

import be.krikkrok.BaseAoc
import kotlin.concurrent.atomics.AtomicLong
import kotlin.concurrent.atomics.ExperimentalAtomicApi

class Day02A02Test : BaseAoc() {
    @OptIn(ExperimentalAtomicApi::class)
    override fun timedFun()  {
        val input = asString(getFile())
        val answer = AtomicLong(0)

        input.split(",").parallelStream().forEach { product ->
            val ids = product.split("-")
            val range = ProductIdRange(ids[0].toLong(), ids[1].toLong())

            (range.firstId..range.secondId).forEach { id ->
                val currentId = id.toString()
                for (i in currentId.length downTo 2) {
                    val parts = splitIntoParts(currentId, i)
                    if (parts?.distinct()?.size == 1) {
                        answer.addAndFetch(currentId.toLong())
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

fun main() {
    Day02A02Test()
}