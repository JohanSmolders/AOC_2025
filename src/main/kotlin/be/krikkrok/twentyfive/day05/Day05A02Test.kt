package be.krikkrok.twentyfive.day05

import be.krikkrok.BaseAoc
//234224296502948 --wrong
//343329651880509
class Day05A02Test : BaseAoc() {
    override fun timedFun() {
        var answer: Long = 0

        val freshIngredients = ArrayList<IngredientRange>()

        asStringList(getFile()).forEach { row ->
            if (row.contains("-")) {
                val fromTo = row.split("-")
                var from = fromTo[0].toLong()
                var to = fromTo[1].toLong()

                val rangeFrom  = freshIngredients.firstOrNull { it.isInRange(from) }
                if(rangeFrom != null) {
                    from = rangeFrom.max + 1
                }

                val rangeTo  = freshIngredients.firstOrNull { it.isInRange(to) }
                if(rangeTo != null) {
                    to = rangeTo.min - 1
                }

                if(to >= from){
                    answer += (to - from) + 1
                }

                freshIngredients.add(IngredientRange(from, to))
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
    Day05A02Test()
}
