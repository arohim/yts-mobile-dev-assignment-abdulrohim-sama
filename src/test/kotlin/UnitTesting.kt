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
    fun `Test small grid`() {
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
    fun `Test large grid`() {
        val grid = Array(1000) { Array(1000) { 1 } }
        assertEquals(1998, breadthFirstSearch.execute(grid))
//        Backtracking causing StackOverflow exception because too much recursive
//        assertEquals(1998, backTrackingSearch.execute(grid))
        assertEquals(1998, aStarSearch.execute(grid))
    }

    @Test
    fun `Test super large grid`() {
        val grid = Array(2000) { Array(2000) { 1 } }
        assertEquals(3998, breadthFirstSearch.execute(grid))
//        Backtracking causing StackOverflow exception because too much recursive
//        assertEquals(3998, backTrackingSearch.execute(grid))
        assertEquals(3998, aStarSearch.execute(grid))
    }

    @Test
    fun `Test no path`() {
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
    fun `Test multiple paths`() {
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
    fun `Test multiple paths2`() {
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
    fun `Test multiple paths3`() {
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
            arrayOf(1, 1, 1, 1, 1)
        )
        assertEquals(14, breadthFirstSearch.execute(grid))
        assertEquals(14, backTrackingSearch.execute(grid))
        assertEquals(14, aStarSearch.execute(grid))
    }
}