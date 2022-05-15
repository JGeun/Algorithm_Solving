class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        return absolutes.zip(signs.map{ if (it) 1 else -1 }).map { it.first * it.second }.sum()
    }
}