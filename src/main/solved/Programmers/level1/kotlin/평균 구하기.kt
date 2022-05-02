class Solution {
    fun solution(arr: IntArray): Double {
        var answer : Double = 0.0
        for(a in arr) answer += a
        return answer/arr.size
    }
}