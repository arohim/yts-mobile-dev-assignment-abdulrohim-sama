package algorithm

import Point

class DepthFirstSearch : ShortestPathFinder {

    private fun isSafe(
        grid: Array<Array<Int>>,
        x: Int,
        y: Int,
        visited: Array<Array<Boolean>>
    ): Boolean {
        return x in grid.indices && y in 0 until grid[0].size && grid[x][y] == 1 && !visited[x][y]
    }

    private fun dfs(
        grid: Array<Array<Int>>,
        x: Int,
        y: Int,
        destX: Int,
        destY: Int,
        visited: Array<Array<Boolean>>,
        pathLength: Int,
        minPath: IntArray
    ) {
        // return the shortest path when we've reached the destination
        if (x == destX && y == destY) {
            minPath[0] = minOf(minPath[0], pathLength)
            return
        }

        visited[x][y] = true

        // Start exploring all possible directions
        val directions = listOf(Point(1, 0), Point(0, 1), Point(-1, 0), Point(0, -1))
        for (dir in directions) {
            val newX = x + dir.x
            val newY = y + dir.y

            // Check if
            // - newX is in boundary
            // - and newY is in boundary
            // - and the new point haven't visited
            // - and the new point is 1
            if (newX in grid.indices
                && newY in 0 until grid[0].size
                && grid[x][y] == 1
                && !visited[x][y]
            ) {
                // start exploring new point
                dfs(
                    grid,
                    newX,
                    newY,
                    destX,
                    destY,
                    visited,
                    pathLength + 1,
                    minPath
                )
            }
        }

        visited[x][y] = false
    }

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

        val visited = Array(grid.size) { Array(grid[0].size) { false } }
        val minPath = intArrayOf(Int.MAX_VALUE)
        dfs(grid, 0, 0, rows - 1, cols - 1, visited, 0, minPath)
        return if (minPath[0] == Int.MAX_VALUE) -1 else minPath[0]
    }
}