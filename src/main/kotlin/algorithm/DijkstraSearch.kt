package algorithm

import Point
import java.util.PriorityQueue

class DijkstraSearch : ShortestPathFinder {
    override fun execute(grid: Array<Array<Int>>): Int {
        // Return -1 if grid is empty
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return -1
        }

        val rows = grid.size
        val cols = grid[0].size

        // Return -1 if it reached the destination
        if (grid[0][0] == 0 || grid[rows - 1][cols - 1] == 0)
            return -1

        // Define which way we will explore in this case we can go right, down, left and right
        val directions = listOf(Point(1, 0), Point(0, 1), Point(-1, 0), Point(0, -1))

        // Create array of distances to save the distance when we visit the point
        val distances = Array(rows) { IntArray(cols) { Int.MAX_VALUE } }

        // Priority queue to store the point that we need to visit with non-decreasing order
        val priorityQueue = PriorityQueue<Point> { a, b ->
            a.cost - b.cost
        }

        // Start from the top-left corner
        distances[0][0] = 0
        priorityQueue.add(Point(0, 0).apply { cost = grid[0][0] })

        while (priorityQueue.isNotEmpty()) {
            val current = priorityQueue.poll()

            // return the distance when we've reached the destination
            if (current.x == rows - 1 && current.y == cols - 1) {
                return distances[current.x][current.y]
            }

            // Start explore all the possible directions
            for (dir in directions) {
                val newX = current.x + dir.x
                val newY = current.y + dir.y

                if (newX in 0 until rows
                    && newY in 0 until cols
                    && grid[newX][newY] == 1
                ) {
                    // Calculate the new cost if the new cost is lower than the distances of the new point,
                    //  then add the point to priority queue, so we can explore next
                    val newCost = distances[current.x][current.y] + grid[newX][newY]
                    if (newCost < distances[newX][newY]) {
                        distances[newX][newY] = newCost
                        priorityQueue.add(Point(newX, newY).apply { cost = newCost })
                    }
                }
            }
//            println("priorityQueue = $priorityQueue")
        }

        return -1
    }
}