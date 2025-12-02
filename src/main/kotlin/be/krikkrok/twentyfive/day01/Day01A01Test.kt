package be.krikkrok.twentyfive.day01

import be.krikkrok.BaseAoc
import java.lang.Math.floorMod

class Day01A01Test : BaseAoc() {
    override fun timedFun() {
        var position = 50
        var zeroCount = 0
        asStringList(getFile()).forEach { rotation ->
            when (rotation.take(1)) {
                "L" -> position -= rotation.drop(1).toInt()
                "R" -> position += rotation.drop(1).toInt()
            }

            position = floorMod(position, 100)

            if (position == 0) {
                zeroCount++
            }
        }

        printResult("Final position: $position")
        printResult("Zero count: $zeroCount")
    }

    override fun getRealFile(): String {
        return "a01.txt"
    }

    override fun runTest(): Boolean {
        return false
    }

    override fun getFolder(): String {
        return "day01"
    }
}

fun main() {
    Day01A01Test()
}