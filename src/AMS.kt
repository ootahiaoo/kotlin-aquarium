import java.time.DayOfWeek
import java.util.*

fun main(args: Array<String>) {
    println("Hello, World!")
//    feedTheFish()
//    println(whatShouldIDoToday("happy").toString())
    val simpleSpice = SimpleSpice()
    println("The spice is ${simpleSpice.spiceName} and the heat is ${simpleSpice.heat}")
}
//
//fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
//    return true
//}
//
//fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true) : Boolean{
//    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
//}
//
//fun feedTheFish() {
//    val day = randomDay()
//    val food = fishFood(day)
//    println("Today is $day so the fish food is $food")
//
//    if (shouldChangeWater(day)) {
//        println("Change the water today")
//    }
//}
//
//fun randomDay(): String {
//    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
//    return week[Random().nextInt(7)]
//}
//
//fun fishFood(day: String): String {
//    var food = "fasting"
//    return when (day) {
//        "Monday" -> "flakes"
//        "Tuesday" -> "pellets"
//        "Wednesday" -> "redworms"
//        "Thursday" -> "granules"
//        "Friday" -> "mosquitoes"
//        "Saturday" -> ""
//        "Sunday" -> "plankton"
//        else -> "fasting"
//
//    }
//}

//fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String{
//
//    return when {
//        isHappy(mood) && isSunny(weather) && isHot(temperature) -> "go swimming"
//        isHappy(mood) && isSunny(weather) && !isHot(temperature) -> "go karaoke"
//        isHappy(mood) && !isSunny(weather) -> "stay home and play games"
//        !isHappy(mood) && !isSunny(weather) -> "stay home and watch a movie"
//        isHappy(mood) -> "go for a walk"
//        !isHappy(mood) -> "go meet a friend"
//        else -> "work"
//    }
//}
//
//fun isHappy(mood: String): Boolean = mood == "happy"
//fun isSunny(weather: String): Boolean = weather == "sunny"
//fun isHot(temperature: Int): Boolean = temperature > 20

class SimpleSpice {

    var spiceName = "curry"
    var spiciness = "mild"
    val heat: Int
        get() = 5

}

class Spice(val name: String, val spiciness: String = "mild") {

    private val heat: Int
        get() {
            return when (spiciness){
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                else -> 0
            }
        }

    val listOfSpices = listOf(Spice("curry", "mild"), Spice("pepper", "medium"),
        Spice("cayenne", "very spicy"))

    init{
        val spiceList = listOfSpices.filter{it.heat < 5}
    }

    fun makeSalt() = Spice("Salt")

}

