data class Point(val x: Int, val y: Int) : Comparable<Point> {
    var f: Int = 0
    override fun compareTo(other: Point): Int = this.f - other.f
}