import java.io.File

fun main(args: Array<String>) {
    val field = File("src/main/resources/beispiel.txt").readLines()
    println(solve(field))
}

private fun solve(field: List<String>): Int {
    return 0
}