import java.util.*

data class Point(val x: Int, val y: Int)

class BreadthFirstSearch {

    fun shortestPath(grid: Array<Array<Int>>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return -1

        val rows = grid.size
        val cols = grid[0].size
        if (grid[0][0] == 0 || grid[rows - 1][cols - 1] == 0) return -1

        val directions = listOf(Point(1, 0), Point(0, 1), Point(-1, 0), Point(0, -1))
        val queue: Queue<Point> = LinkedList()
        val visited = Array(rows) { BooleanArray(cols) }

        queue.add(Point(0, 0))
        visited[0][0] = true
        var steps = 1

        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val point = queue.poll()
                if (point.x == rows - 1 && point.y == cols - 1) return steps

                for (dir in directions) {
                    val newX = point.x + dir.x
                    val newY = point.y + dir.y

                    if (newX in 0 until rows && newY in 0 until cols && !visited[newX][newY] && grid[newX][newY] == 1) {
                        queue.add(Point(newX, newY))
                        visited[newX][newY] = true
                    }
                }
            }
            steps++
        }
        return -1
    }

}