package Exercices

enum class Direction {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game {
    var path = mutableListOf<Direction>(Direction.START)
    val north = { path.add(Direction.NORTH) }
    val south = { path.add(Direction.SOUTH) }
    val east = { path.add(Direction.EAST) }
    val west = { path.add(Direction.WEST) }
    val end = {
        path.add(Direction.END)
        println("Game Over: $path")
        path.clear()
        false
    }

    fun makeMove(command: String?) {
        if (command.equals("n")) move(north)
        else if (command.equals("s")) move(south)
        else if (command.equals("e")) move(east)
        else if (command.equals("w")) move(west)
        else move(end)
    }
}


fun main(args: Array<String>) {
    val game = Game()
    while (true) {
        print("Enter a direction: n/s/e/w:")
        game.makeMove(readLine())
    }

}

fun move(where: () -> Boolean) {
    where.invoke()
}