package be.krikkrok.twentyfive.day03

import be.krikkrok.BaseAoc

class Day03A02Test : BaseAoc() {
    override fun timedFun() {
        var answer: Long = 0
        asStringList(getFile()).forEach { bank ->
            var bankLeft = bank
            var subBank  = bankLeft.take(bank.length - 11)
            var found = getMaxInt(subBank)
            var selectedBank = found

            (2 .. 12).forEach { pass ->
                bankLeft = bankLeft.substringAfter(found)
                subBank = bankLeft.dropLast((12 - pass))
                found = getMaxInt(subBank)
                selectedBank += found
             }
            answer = answer.plus(selectedBank.toLong())
        }

        printResult("$answer")
    }

    private fun getMaxInt(bank: String): String {
        return bank.toCharArray().maxBy { it }.toString()
    }

    override fun getRealFile(): String {
        return "a01.txt"
    }

    override fun runTest(): Boolean {
        return false
    }

    override fun getFolder(): String {
        return "day03"
    }
}

fun main() {
    Day03A02Test()
}