import java.io.File
import kotlin.random.Random

fun main() {
    val field = File("src/main/resources/wald.txt").readLines()
    println(solve(field, 3))
    println(solveAdvanced(field, 3 to 1))
}

private fun solve(field: List<String>, xValue: Int): Int {
    val width = field[0].length
    return field.indices.count {y ->
        field[y][y * xValue % width] == '#'
    }
}

private fun solveAdvanced(field: List<String>, vector: Pair<Int, Int>): Int {
    val (dx, dy) = vector
    val width = field[0].length
    return field.indices.count { y ->
        y % dy == 0 && field[y][y * dx / dy % width] == '#'
    }
}
