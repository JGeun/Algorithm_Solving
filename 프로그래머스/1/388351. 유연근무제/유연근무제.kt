// schedules의 길이가 7시 ~ 11시이기 때문에 23시에서 0시로 넘어가는 케이스 고려 X
// 핵심: 9시 58분 출근 예정이면 1008까지 와야 함.
class Solution {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer: Int = 0
        
        for (i in schedules.indices) {
            val schedule = schedules[i]
            var hour = schedule / 100
            var min = (schedule % 100 + 10)
            if (min >= 60) {
                hour += 1
                min -= 60
            }
                
            val maxTime = hour * 100 + min
            
            var isPass = true
            for (j in timelogs[i].indices) {
                val day = (startday + j) % 7
                
                // 토요일 일요일 고려 X
                if (day == 6 || day == 0) continue
                
                // 지각 - 대상자 아님
                if (timelogs[i][j] > maxTime) {
                    isPass = false
                    break
                }
            }
            
            if (isPass) {
                answer += 1
            }
        }
        
        return answer
    }
}   