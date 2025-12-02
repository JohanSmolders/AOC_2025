package be.krikkrok.twentyfive.day02

import be.krikkrok.BaseAoc

class Day02A01Test: BaseAoc() {
    init {
       val input = asString(getFile())
        var answer: Long = 0

        input.split(",").forEach { product ->
            val ids = product.split("-")
            val range = ProductIdRange(ids[0].toLong(), ids[1].toLong())

            (range.firstId .. range.secondId).forEach { id ->
                val currentId = id.toString()
                if(currentId.length % 2 == 0){
                    val split = splitInHalf(currentId)
                    if(split.first == split.second){
                        answer += currentId.toLong()
                    }
                }
            }
        }

        printResult("$answer")

    }

    fun splitInHalf(s: String): Pair<String, String> {
        val mid = s.length / 2
        return s.substring(0, mid) to s.substring(mid)
    }

    override fun getRealFile(): String{
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
    Day02A01Test()
}