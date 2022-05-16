class Solution {
    fun solution(a: IntArray, b: IntArray): Int {
        return a.zip(b).map {it.first * it.second }.sum()
    }
}