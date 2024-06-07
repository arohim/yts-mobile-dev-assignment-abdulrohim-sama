package algorithm

import Point

class BackTrackingSearch : ShortestPathFinder {


    override fun execute(grid: Array<Array<Int>>): Int {
        if (grid.isEmpty() || grid.first().isEmpty() || grid.first().first() == 0 || grid.last().last() == 0)
            return -1

        val rows = grid.size
        val cols = grid.first().size

        val directions = listOf(Point(1, 0), Point(0, 1), Point(-1, 0), Point(0, -1))
        val visited = Array(rows) { BooleanArray(cols) }
        var shortestPath = Int.MAX_VALUE

        fun backtrack(x: Int, y: Int, pathLength: Int) {
            if (x == rows - 1 && y == cols - 1) {
                shortestPath = minOf(shortestPath, pathLength)
                return
            }
            visited[x][y] = true
            for (direction in directions) {
                val newX = x + direction.x
                val newY = y + direction.y

                if (newX >= 0
                    && newY >= 0
                    && newX < rows
                    && newY < cols
                    && grid[newX][newY] == 1
                    && !visited[newX][newY]
                ) {
                    backtrack(newX, newY, pathLength + 1)
                }
            }
            visited[x][y] = false
        }

        backtrack(0, 0, 0)

        return if (shortestPath == Int.MAX_VALUE) -1 else shortestPath
    }

}