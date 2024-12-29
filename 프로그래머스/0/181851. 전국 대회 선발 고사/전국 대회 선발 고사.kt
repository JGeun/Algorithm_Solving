class Solution {
    fun solution(rank: IntArray, attendance: BooleanArray): Int {
        var answer: Int = 0
        val (a, b, c) = rank.mapIndexed { index, value ->
            Pair(index, value)
        }.filter {
            attendance[it.first]
        }.sortedBy {
            it.second
        }.subList(0, 3)
        
        return a.first * 10000 + b.first * 100 + c.first
    }
}