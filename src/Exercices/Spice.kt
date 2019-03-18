package Exercices

fun main(args: Array<String>) {
    val simpleSpice = SimpleSpice()
    println("The spice is ${simpleSpice.spiceName} and the heat is ${simpleSpice.heat}")
}

class Curry(name: String, spiciness: String,
            color: SpiceColor = YellowSpiceColor) : Spice(name, spiciness, color), Grinder {
    override fun grind() {
    }

    override fun prepareSpice() {
        grind()
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: String
}

object YellowSpiceColor : SpiceColor {
    override val color = "Yellow"
}

abstract class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor) : SpiceColor by color {

    abstract fun prepareSpice()

    private val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                else -> 0
            }
        }

//    val listOfSpices = listOf(Spice("curry", "mild"), Spice("pepper", "medium"),
//        Spice("cayenne", "very spicy"))
//
//    init{
//        val spiceList = listOfSpices.filter{it.heat < 5}
//    }
//
//    fun makeSalt() = Spice("Salt")
}

class SimpleSpice {

    var spiceName = "curry"
    var spiciness = "mild"
    val heat: Int
        get() = 5

}