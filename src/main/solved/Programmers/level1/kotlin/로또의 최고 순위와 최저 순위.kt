class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer = intArrayOf(6, 6, 5, 4, 3, 2, 1)
        var zeroCnt = 0
        var correctCnt = 0

        for (lotto in lottos) {
            if (lotto in win_nums) correctCnt += 1
            if (lotto == 0) zeroCnt += 1
        }

        return intArrayOf(answer[zeroCnt+correctCnt], answer[correctCnt])
    }
}