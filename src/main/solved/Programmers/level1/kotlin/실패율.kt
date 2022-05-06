data class Stage(var level: Int, var pass: Int, var fail: Int) {
    val failRate: Float
        get() = if (fail+pass == 0) 0.0f else (fail.toFloat()) / (pass+fail)
}

class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var stageInfo = Array(N, { Stage(it+1, 0, 0)})

        for(level in stages) {
            for (i in 0..(level-2)) {
                stageInfo[i].pass++
            }
            if (level != N+1) stageInfo[level-1].fail++
        }
        stageInfo.sortByDescending { it.failRate }
        return stageInfo.map{ it.level }.toIntArray()
    }
}