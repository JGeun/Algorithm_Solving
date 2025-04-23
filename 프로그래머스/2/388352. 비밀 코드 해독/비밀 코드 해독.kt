class Solution {
    private val SIZE = 5
    private val combination = IntArray(SIZE)
    private var resultCount = 0

    fun solution(n: Int, q: Array<IntArray>, ans: IntArray): Int {
        generateCombinations(n, q, ans, 0, 0)
        return resultCount
    }

    private fun generateCombinations(n: Int, q: Array<IntArray>, ans: IntArray, depth: Int, start: Int) {
        if (depth == SIZE) {
            if (isValidCombination(q, ans)) {
                resultCount++
            }
            return
        }

        for (i in (start + 1)..n) {
            combination[depth] = i
            generateCombinations(n, q, ans, depth + 1, i)
        }
    }

    private fun isValidCombination(q: Array<IntArray>, ans: IntArray): Boolean {
        for (i in q.indices) {
            val requiredMatchCount = ans[i]
            val conditionSet = q[i].toSet()

            val matchCount = combination.count { it in conditionSet }

            if (matchCount != requiredMatchCount) {
                return false
            }
        }
        return true
    }
}