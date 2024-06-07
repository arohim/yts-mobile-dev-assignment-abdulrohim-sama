// Unit Tests
import algorithm.AStarSearch
import algorithm.BackTrackingSearch
import algorithm.BreadthFirstSearch
import algorithm.ShortestPathFinder
import kotlin.test.Test
import kotlin.test.assertEquals

class ShortestPathTest {

    private val breadthFirstSearch: ShortestPathFinder = BreadthFirstSearch()
    private val backTrackingSearch: ShortestPathFinder = BackTrackingSearch()
    private val aStarSearch: ShortestPathFinder = AStarSearch()

    @Test
    fun testSmallGrid() {
        val grid = arrayOf(
            arrayOf(1, 1, 1),
            arrayOf(1, 0, 0),
            arrayOf(1, 1, 1)
        )
        assertEquals(4, breadthFirstSearch.execute(grid))
        assertEquals(4, backTrackingSearch.execute(grid))
        assertEquals(4, aStarSearch.execute(grid))
    }

    @Test
    fun testLargeGrid() {
        val grid = Array(1000) { Array(1000) { 1 } }
        assertEquals(1998, breadthFirstSearch.execute(grid))
//        assertEquals(1998, backTrackingSearch.execute(grid))
        assertEquals(1998, aStarSearch.execute(grid))
    }

    @Test
    fun testSuperLargeGrid() {
        val grid = Array(2000) { Array(2000) { 1 } }
        assertEquals(3998, breadthFirstSearch.execute(grid))
//        assertEquals(3998, backTrackingSearch.execute(grid))
        assertEquals(3998, aStarSearch.execute(grid))
    }

    @Test
    fun testNoPath() {
        val grid = arrayOf(
            arrayOf(1, 0, 1),
            arrayOf(0, 0, 0),
            arrayOf(1, 1, 1)
        )
        assertEquals(-1, breadthFirstSearch.execute(grid))
        assertEquals(-1, backTrackingSearch.execute(grid))
        assertEquals(-1, aStarSearch.execute(grid))
    }

    @Test
    fun testMultiplePaths() {
        val grid = arrayOf(
            arrayOf(1, 1, 0, 1),
            arrayOf(1, 1, 0, 1),
            arrayOf(1, 1, 1, 1),
            arrayOf(0, 0, 1, 1)
        )
        assertEquals(6, breadthFirstSearch.execute(grid))
        assertEquals(6, backTrackingSearch.execute(grid))
        assertEquals(6, aStarSearch.execute(grid))
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
        assertEquals(11, breadthFirstSearch.execute(grid))
        assertEquals(11, backTrackingSearch.execute(grid))
        assertEquals(11, aStarSearch.execute(grid))
    }

    @Test
    fun testMultiplePaths3() {
        val grid = arrayOf(
            arrayOf(1, 1, 1, 1, 1),
            arrayOf(1, 0, 0, 1, 0),
            arrayOf(1, 0, 0, 1, 0),
            arrayOf(1, 1, 1, 1, 1),
            arrayOf(1, 1, 1, 1, 1),
            arrayOf(1, 1, 1, 1, 1),
            arrayOf(1, 1, 1, 1, 1),
            arrayOf(1, 1, 1, 1, 1),
            arrayOf(1, 1, 1, 1, 1),
            arrayOf(1, 1, 1, 1, 1),
            arrayOf(1, 1, 1, 1, 1),
        )
        assertEquals(14, breadthFirstSearch.execute(grid))
        assertEquals(14, backTrackingSearch.execute(grid))
        assertEquals(14, aStarSearch.execute(grid))
    }
}