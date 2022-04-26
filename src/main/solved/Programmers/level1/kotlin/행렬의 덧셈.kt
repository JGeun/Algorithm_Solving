class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        return Array(arr1.size){ row ->
            IntArray(arr1[0].size){ col ->
                arr1[row][col] + arr2[row][col]
            }
        }
    }
}