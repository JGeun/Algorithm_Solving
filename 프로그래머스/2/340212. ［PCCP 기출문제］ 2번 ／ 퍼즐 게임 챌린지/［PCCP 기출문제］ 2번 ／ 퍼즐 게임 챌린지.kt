/**
 * diff: 100,000, level => 1일 경우 99,999(100,000 - 1) * (600,000) + 300,000 -> 60,000,000,000 => Long 범위 계산이 필요.
 * level의 최대 값: 현재 최대 diffs값 중 가장 큰 값이 동일
 */ 
class Solution {
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {
        var answer: Int = 1
        var R = getMaxLevel(diffs)
        var L = 1
    
        while (L <= R) {
            val mid = (L+R)/2
            if (validation(mid, diffs, times, limit)) {
                R = mid - 1
                answer = mid
            } else {
                L = mid + 1
            }
        }
        
        return answer
    }
    
    private fun validation(level: Int, diffs: IntArray, times: IntArray, limit: Long): Boolean {
        return calculateTotalTime(level, diffs, times) <= limit
    }
    
    private fun calculateTotalTime(level: Int, diffs: IntArray, times: IntArray): Long {
        var res = times[0].toLong()
        
        for (index in 1 until diffs.size) {
            val diff = diffs[index]
            val dl = if (level >= diff) 0 else diff - level
            
            res += dl.toLong() * (times[index-1] + times[index]) + times[index]
        }
        
        return res
    }
    
    private fun getMaxLevel(diffs: IntArray): Int {
        var maxLevel = 1
        for (diff in diffs) {
            maxLevel = Math.max(maxLevel, diff)   
        }
        return maxLevel
    }
}