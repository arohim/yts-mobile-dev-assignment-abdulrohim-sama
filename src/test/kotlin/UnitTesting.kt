// Unit Tests
import kotlin.test.Test
import kotlin.test.assertEquals

class ShortestPathTest {

    private val breadthFirstSearch = BreadthFirstSearch()
    private val backTracking = BackTracking()

    @Test
    fun testSmallGrid() {
        val grid = arrayOf(
            arrayOf(1, 1, 1),
            arrayOf(0, 1, 0),
            arrayOf(1, 1, 1)
        )
        assertEquals(5, breadthFirstSearch.shortestPath(grid))
        assertEquals(5, backTracking.shortestPath(grid))
    }

    @Test
    fun testLargeGrid() {
        val grid = Array(1000) { Array(1000) { 1 } }
        assertEquals(1999, breadthFirstSearch.shortestPath(grid))
        assertEquals(1999, backTracking.shortestPath(grid))
    }

    @Test
    fun testSuperLargeGrid() {
        val grid = Array(2000) { Array(2000) { 1 } }
        assertEquals(3999, breadthFirstSearch.shortestPath(grid))
        assertEquals(3999, backTracking.shortestPath(grid))
    }

    @Test
    fun testNoPath() {
        val grid = arrayOf(
            arrayOf(1, 0, 1),
            arrayOf(0, 0, 0),
            arrayOf(1, 1, 1)
        )
        assertEquals(-1, breadthFirstSearch.shortestPath(grid))
        assertEquals(-1, backTracking.shortestPath(grid))
    }

    @Test
    fun testMultiplePaths() {
        val grid = arrayOf(
            arrayOf(1, 1, 0, 1),
            arrayOf(1, 1, 0, 1),
            arrayOf(1, 1, 1, 1),
            arrayOf(0, 0, 1, 1)
        )
        assertEquals(7, breadthFirstSearch.shortestPath(grid))
        assertEquals(7, backTracking.shortestPath(grid))
    }

    @Test
    fun testMultiplePaths2() {
        val grid = arrayOf(
            arrayOf(1, 1, 1, 1, 1, 1, 1, 1),
            arrayOf(1, 0, 0, 1, 0, 0, 0, 1),
            arrayOf(1, 0, 0, 1, 0, 0, 0, 1),
            arrayOf(1, 1, 1, 1, 1, 1, 1, 1),
            arrayOf(1, 1, 1, 1, 1, 1, 1, 1)
        )
        assertEquals(12, breadthFirstSearch.shortestPath(grid))
        assertEquals(12, backTracking.shortestPath(grid))
    }
}