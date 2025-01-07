/**
 * 해쉬맵에 저장해서 개수로 판별
 * 1인 경우: 모든 같은 숫자
 * 2인 경우: 3, 1로 나눠지면 2번 케이스, 아니면 3번 케이스
 * 3인 경우: p, q, r
 * 4인 경우: 제일 작은 숫자
 */
import kotlin.collections.*
import kotlin.math.*

class Solution {
    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
        val numMap = hashMapOf<Int, Int>()
            .apply {
                put(a, getOrDefault(a, 0) + 1)
                put(b, getOrDefault(b, 0) + 1)
                put(c, getOrDefault(c, 0) + 1)
                put(d, getOrDefault(d, 0) + 1)
            }

        
        return when (numMap.size) {
            1 -> 1111 * numMap.keys.first()
            2 -> {
                val (p, q) = numMap.keys.sortedByDescending { numMap[it] }
                if (numMap[p] == numMap[q]) {
                    (p+q) * abs(p-q)
                } else {
                    (10 * p + q.toFloat()).pow(2).toInt()
                }
            }
            3 -> {
                val (p, q, r) = numMap.keys.sortedByDescending { numMap[it] }
                q * r
            }
            4 -> numMap.keys.minOf { it }
            else -> 0
        }
    }
}