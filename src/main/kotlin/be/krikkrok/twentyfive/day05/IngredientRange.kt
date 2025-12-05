package be.krikkrok.twentyfive.day05

data class IngredientRange(val min: Long, val max: Long){
    fun isInRange(ingredient: Long): Boolean {
        return ingredient in min..max
    }
}
