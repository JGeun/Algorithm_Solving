/**
 * 핵심: 시간 관리 -> 큐에 담아주고 해당 시간이 이전에 증설된 시간 + k보다 작은 경우 제거하는 작업 필요.
 */
import kotlin.collections.*

class Solution {
    fun solution(players: IntArray, m: Int, k: Int): Int {
        var answer: Int = 0
        val serverQueue = ArrayDeque<Int>()
        for (i in 0 until players.size) {
            val player = players[i]
            
            // 시간이 지난 server 제거
            while (serverQueue.isNotEmpty()) {
                if (serverQueue.get(0) + k > i) break
                serverQueue.removeFirst();
            }
            
            // 현재 증설된 서버와 플레이어 수 비교
            val accectableCnt = calcAcceptableCnt(serverQueue.size, m)
            if(player - accectableCnt <= 0) continue
            
            val needServerCnt = (player / m) - serverQueue.size
            if (needServerCnt <= 0) continue
            
            for (j in 0 until needServerCnt) {
                serverQueue.add(i);
            }
            
            answer += needServerCnt;
        }
        
        return answer
    }
    
    private fun calcAcceptableCnt(serverCnt: Int, m: Int): Int {
        return serverCnt * m;
    }
}