package be.krikkrok.twentyfive.day05

import be.krikkrok.BaseAoc

class Day05A01Test : BaseAoc() {
    override fun timedFun() {
        var answer: Long = 0

        val freshIngredients = ArrayList<IngredientRange>()

        asStringList(getFile()).forEach { row ->
            if (row.contains("-")) {
                val fromTo = row.split("-")
                freshIngredients.add(IngredientRange(fromTo[0].toLong(), fromTo[1].toLong()))
            }else if(row != "" && freshIngredients.any { it.isInRange(row.toLong()) }) {
                answer++
            }
        }


        printResult("$answer")
    }


    override fun getRealFile(): String {
        return "a01.txt"
    }

    override fun runTest(): Boolean {
        return false
    }

    override fun getFolder(): String {
        return "day05"
    }
}

fun main() {
    Day05A01Test()
}