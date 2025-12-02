package be.krikkrok.twentyfive.day01

import be.krikkrok.BaseAoc
import java.lang.Math.floorMod

class Day01A02Test: BaseAoc() {
    override fun timedFun() {

        var position = 50
        var zeroCount = 0
        asStringList(getFile()).forEach { rotation ->
            when(rotation.take(1)){
                "L" -> {
                    val rotationResult = rotateFor(position, RotationSide.LEFT, rotation.drop(1).toInt())
                    zeroCount += rotationResult.zeroClicks
                    position = rotationResult.finalPosition
                }
                "R" -> {
                    val rotationResult = rotateFor(position, RotationSide.RIGHT, rotation.drop(1).toInt())
                    zeroCount += rotationResult.zeroClicks
                    position = rotationResult.finalPosition
                }
            }
        }

        printResult("Final position: $position")
        printResult("Zero count: $zeroCount")
    }

    private fun rotateFor(startPosition: Int, rotationSide: RotationSide, amount: Int): RotationResult {
        var zeroClicks = 0
        var currentPosition = startPosition

        (0 until amount).forEach {
            when(rotationSide){
                RotationSide.LEFT -> currentPosition--
                RotationSide.RIGHT -> currentPosition++
            }

            if(currentPosition == 0 || currentPosition == 100){
                zeroClicks++
            }

            currentPosition  = floorMod(currentPosition, 100)
        }

        return RotationResult(zeroClicks, currentPosition)
    }

    override fun getRealFile(): String{
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
    Day01A02Test()
}