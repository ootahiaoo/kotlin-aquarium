package Exercices

import kotlin.random.Random

const val MAX_BORROWED_BOOK = 5

fun main(args: Array<String>) {
    val book = Book("Romeon and Juliet", "William Shakespeare", 1597, 300)
    val bookTitleAuthor = book.getTitleAuthor()
    val bookTitleAuthorYear = book.getTitleAuthorYear()

    println("Here is your book ${bookTitleAuthor.first} by ${bookTitleAuthor.second}")

    println(
        "Here is your book ${bookTitleAuthorYear.first} " +
                "by ${bookTitleAuthorYear.second} written in ${bookTitleAuthorYear.third}"
    )

    val allBooks = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")

    val library = mapOf("Shakespeare" to allBooks)
    println(library.any { it.value.contains("Hamlet") })

    val moreBooks = mutableMapOf<String, String>("Capital de la douleur" to "Paul Eluard")
    moreBooks.getOrPut("Les Miserables") { "Victor Hugo" }
    println(moreBooks)

    val puppy = Puppy()
    val book2 = Book("Oliver Twist", "Charles Dickens", 1837, 540)

    while (book2.pages > 0) {
        puppy.playwithBook(book2)
        println("${book2.pages} left in ${book2.title}")
    }
    println("Sad puppy, no more pages in ${book2.title}. ")

}

fun canBorrow(borrowedBook: Int): Boolean {
    return (borrowedBook < MAX_BORROWED_BOOK)
}

fun Book.weight(): Double {
    return (pages * 1.5)
}

fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

class Puppy {
    fun playwithBook(book: Book) {
        book.tornPages(Random.nextInt(12))
    }
}

open class Book(val title: String, val author: String, val year: Int, var pages: Int) {

    companion object {
        const val BASE_URL = "https://www.library.com"
    }

    private var currentPage = 1

    open fun readPage() {
        currentPage++
    }

    fun printUrl() {
        println("${BASE_URL + title}.html")
    }

    fun getTitleAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}

//class eBook(title: String, author: String, var format: String = "text") : Book(title, author) {
//
//    private var wordsRead = 0
//
//    override fun readPage() {
//        wordsRead = wordsRead + 250
//    }
//}