import java.util.*

class BreadthFirstSearch {

    fun shortestPath(grid: Array<Array<Int>>): Int {
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

        // Create queue to store the point that we will explore
        val queue: Queue<Point> = LinkedList()
        val visited = Array(rows) { BooleanArray(cols) }

        // Starting point
        queue.add(Point(0, 0))

        // Mark the staring point as a visited point
        visited[0][0] = true

        // Also count the starting point as 1 step
        var steps = 1

        // Loop until queue is empty
        //    when queue is empty means we have visited all the possible path
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                // New starting point to explore
                val point = queue.poll()

                // Return steps when we've reached the destination
                if (point.x == rows - 1 && point.y == cols - 1)
                    return steps

                // Start explore using pre-defined directions
                for (dir in directions) {
                    // Move to the new point
                    val newX = point.x + dir.x
                    val newY = point.y + dir.y

                    // Check if
                    // - newX is in boundary
                    // - and newY is in boundary
                    // - and the new point haven't visited
                    // - and the new point is 1
                    if (newX in 0 until rows
                        && newY in 0 until cols
                        && !visited[newX][newY]
                        && grid[newX][newY] == 1
                    ) {
                        // add the new point into queue to be next point to explore
                        queue.add(Point(newX, newY))

                        // mark the new point to be visited
                        visited[newX][newY] = true
                    }
                }
            }
            // Increase step
            steps++
        }
        return -1
    }

}