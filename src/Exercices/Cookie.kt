package Exercices
fun main(args: Array<String>) {
    var fortune: String = ""
    while (!fortune.contains("Stuff again")) {
        fortune = getFortune(getBirthday())
        println("\nYour fortune is: $fortune")
    }
}

fun getBirthday() : Int{
    return readLine()?.toInt() ?:1
}

fun getFortune(birthday : Int) : String{
    val fortuneMessage = listOf("Stuff", "Stuff again", "Stuff once more")
    val index = when (birthday){
        in 1..15 -> 0
        in 15..30 -> 1
        else -> 3
    }
    return fortuneMessage[index]
}

