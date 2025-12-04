package be.krikkrok.twentyfive.day04

import be.krikkrok.BaseAoc
import jdk.internal.org.jline.utils.InfoCmp
import java.util.LinkedList

class Day04A02Test : BaseAoc() {
    override fun timedFun() {

        var rows = asStringList(getFile())

        var accesibleRoll = 0
        var previousRolls = -1

        while(accesibleRoll != previousRolls) {
            previousRolls = accesibleRoll
            var newRows = LinkedList<String>()
            (0 until rows.size).forEach { rowId ->
                var row = rows[rowId]
                var newRow = StringBuilder()

                (0 until row.length).forEach { columnId ->
                    if(isRoll(rows, rowId, columnId) == 1){
                        if((isRoll(rows, rowId, columnId + 1) +
                                    isRoll(rows, rowId, columnId - 1) +
                                    isRoll(rows, rowId -1 , columnId) +
                                    isRoll(rows, rowId -1, columnId - 1) +
                                    isRoll(rows, rowId -1, columnId + 1) +
                                    isRoll(rows, rowId + 1, columnId) +
                                    isRoll(rows, rowId + 1 , columnId - 1) +
                                    isRoll(rows, rowId + 1, columnId + 1)
                                    ) < 4){
                            accesibleRoll++
                            newRow.append(".")
                        }else{
                            newRow.append("@")
                        }
                    }else{
                        newRow.append(".")
                    }
                }
                newRows.add(newRow.toString())
            }
            rows = newRows
        }



        printResult("$accesibleRoll")
    }

    private fun isRoll(rows: LinkedList<String>, rowId: Int, columnId: Int): Int {
        if(rowId < 0 || columnId < 0 || rowId > rows.size  - 1|| rows[rowId].toCharArray().size - 1 < columnId) {
            return 0
        }
        return if (rows[rowId].toCharArray()[columnId] == '@') 1 else 0
    }

    override fun getRealFile(): String {
        return "a01.txt"
    }

    override fun runTest(): Boolean {
        return false
    }

    override fun getFolder(): String {
        return "day04"
    }
}

fun main() {
    Day04A02Test()
}