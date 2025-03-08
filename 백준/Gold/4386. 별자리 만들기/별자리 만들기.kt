import java.util.*
import kotlin.collections.*

// 1. 별 x,y 등록
// 2. 각 별들의 dist를 저장하는 List 생성
// 3. 배열로 다 연결되었는지 체크 (첫 번째 별에서 부터 시작)
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    // 입력
    val n = readLine().toInt()
    val stars = mutableListOf<Star>()

    repeat(n) {
        val (x, y) = readLine().split(" ").map { it.toDouble() }
        stars.add(Star(x, y))
    }



    // 첫 번째 별을 기준으로 탐색 시작
    val pq = PriorityQueue<Dist>(compareBy { it.weight })
    val visited = BooleanArray(n) { false }
    var res = 0.0
    var count = 0

    pq.add(Dist(0, 0.0))

    while (pq.isNotEmpty()) {
        val (curIdx, weight) = pq.poll()

        if (visited[curIdx]) continue
        visited[curIdx] = true
        res += weight
        count++

        if (count == n) break // 모든 정점을 방문하면 종료

        for (next in 0 until n) {
            if (!visited[next]) {
                val dist = calcWeight(stars[curIdx], stars[next])
                pq.add(Dist(next, dist))
            }
        }
    }

    println(String.format("%.2f", res)) // 소수점 둘째 자리까지 출력
}

fun calcWeight(star1: Star, star2: Star): Double {
    return Math.sqrt(Math.pow((star1.x - star2.x), 2.0) + Math.pow((star1.y - star2.y), 2.0))
}

data class Star(
    val x: Double,
    val y: Double
)

data class Dist(
    val starIdx: Int,
    val weight: Double
)