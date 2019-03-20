package Exercices

fun main(args: Array<String>) {
    val simpleSpice = SimpleSpice()
    println("The spice is ${simpleSpice.spiceName} and the heat is ${simpleSpice.heat}")

    val spiceCabinet = listOf(
        SpiceContainer(Curry("Yellow Curry", "mild")),
        SpiceContainer(Curry("Red Curry", "medium")),
        SpiceContainer(Curry("Green Curry", "spicy"))
    )

    for (element in spiceCabinet) println(element.label)
}


data class SpiceContainer(val spice: Spice) {

    val label = spice.name
}

class Curry(
    name: String, spiciness: String,
    color: SpiceColor = YellowSpiceColor
) : Spice(name, spiciness, color), Grinder {
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
    val color: Color
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00);
}

object YellowSpiceColor : SpiceColor {
    override val color = Color.YELLOW
}

sealed class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor) : SpiceColor by color {

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