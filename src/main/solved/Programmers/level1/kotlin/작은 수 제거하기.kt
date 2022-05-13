class Solution {
    fun solution(arr: IntArray): IntArray {
        if(arr.size == 1) return arrayOf(-1).toIntArray()
        else return arr.filter { it != arr.minOrNull() }.toIntArray()
    }
}