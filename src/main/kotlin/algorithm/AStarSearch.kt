package algorithm

import Point
import java.util.PriorityQueue
import kotlin.math.abs

/**
 * Time complexity:O(n * m log (n * m))
 *    where n * m is the size of the row
 *          m is the size of the column
 *          log (n * m) is time complexity of add/poll operations for priority queue
 *
 * Space complexity: O(n * m)
 *   uses a priority queue, visited and gScore, which can store up to O(n * m) elements
 */
class AStarSearch : ShortestPathFinder {

    private fun heuristic(a: Point, b: Point): Int {
        return abs(a.x - b.x) + abs(a.y - b.y)
    }

    override fun execute(grid: Array<Array<Int>>): Int {
        // Return -1 if grid is empty
        if (grid.isEmpty() || grid[0].isEmpty())
            return -1

        val rows = grid.size
        val cols = grid[0].size

        // Return -1 if it reached the destination
        if (grid[0][0] == 0 || grid[rows - 1][cols - 1] == 0)
            return -1

        // Define which way we will explore in this case we can go right, down, left and right
        val directions = listOf(Point(1, 0), Point(0, 1), Point(-1, 0), Point(0, -1))

        val start = Point(0, 0)
        val goal = Point(rows - 1, cols - 1)
        val openSet = PriorityQueue<Point> { a, b ->
            a.cost - b.cost
        }
        val gScore = Array(rows) { IntArray(cols) { Int.MAX_VALUE } }
        val visited = Array(rows) { BooleanArray(cols) }

        gScore[0][0] = 0
        start.cost = heuristic(start, goal)
        openSet.add(start)

        while (openSet.isNotEmpty()) {
            val current = openSet.poll()

            // Return the score when we've reached the destination
            if (current == goal)
                return gScore[current.x][current.y]

            visited[current.x][current.y] = true

            // Start explore using pre-defined directions
            for (dir in directions) {
                val newX = current.x + dir.x
                val newY = current.y + dir.y

                // Check if
                // - newX is in boundary
                // - and newY is in boundary
                // - and the new point haven't visited
                // - and the new point is 1
                if (newX in 0 until rows
                    && newY in 0 until cols
                    && grid[newX][newY] == 1
                    && !visited[newX][newY]
                ) {
                    // Use gScore + heuristic to evaluate which point we should visit next
                    val tentativeGScore = gScore[current.x][current.y] + 1
                    if (tentativeGScore < gScore[newX][newY]) {
                        gScore[newX][newY] = tentativeGScore
                        val neighbor = Point(newX, newY)
                        neighbor.cost = tentativeGScore + heuristic(neighbor, goal)
                        openSet.add(neighbor)
                    }
                }
            }
        }
        return -1
    }

}