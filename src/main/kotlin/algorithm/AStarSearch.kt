package algorithm

import Point
import java.util.*
import kotlin.math.abs


class AStarSearch : ShortestPathFinder {

    private fun heuristic(a: Point, b: Point): Int {
        return abs(a.x - b.x) + abs(a.y - b.y)
    }

    override fun execute(grid: Array<Array<Int>>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return -1

        val rows = grid.size
        val cols = grid[0].size
        if (grid[0][0] == 0 || grid[rows - 1][cols - 1] == 0) return -1

        val directions = listOf(Point(1, 0), Point(0, 1), Point(-1, 0), Point(0, -1))
        val start = Point(0, 0)
        val goal = Point(rows - 1, cols - 1)
        val openSet = PriorityQueue<Point>()
        val gScore = Array(rows) { IntArray(cols) { Int.MAX_VALUE } }
        val visited = Array(rows) { BooleanArray(cols) }

        gScore[0][0] = 0
        start.f = heuristic(start, goal)
        openSet.add(start)

        while (openSet.isNotEmpty()) {
            val current = openSet.poll()
            if (current == goal) return gScore[current.x][current.y]

            visited[current.x][current.y] = true
            for (dir in directions) {
                val newX = current.x + dir.x
                val newY = current.y + dir.y

                if (newX in 0 until rows && newY in 0 until cols && grid[newX][newY] == 1 && !visited[newX][newY]) {
                    val tentativeGScore = gScore[current.x][current.y] + 1
                    if (tentativeGScore < gScore[newX][newY]) {
                        gScore[newX][newY] = tentativeGScore
                        val neighbor = Point(newX, newY)
                        neighbor.f = tentativeGScore + heuristic(neighbor, goal)
                        openSet.add(neighbor)
                    }
                }
            }
        }
        return -1
    }

}