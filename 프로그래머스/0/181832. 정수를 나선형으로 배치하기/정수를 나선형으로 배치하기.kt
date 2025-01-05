/*
 * level은 채우고자 하는 테두리
 * level에 따라 각 변마다 n-level위치에서 채우면 됨.
 */
class Solution {
    fun solution(n: Int): Array<IntArray> {
        var answer: Array<IntArray> = Array(n) { IntArray(n) }
        var index = 1
        var level = 0
        
        while (index <= n * n) {
            for (x in level until n-level) {
                answer[level][x] = index++
            }
            
            for (y in level+1 until n-level) {
                answer[y][n-1-level] = index++
            }
            
            for (x in n-1-level-1 downTo level) {
                answer[n-1-level][x] = index++
            }
            
            for (y in n-1-level-1 downTo level+1) {
                answer[y][level] = index++
            }
            
            level += 1
        }
        
        return answer
    }
}