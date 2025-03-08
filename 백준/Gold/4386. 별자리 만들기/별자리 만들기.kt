import kotlin.math.min

// 1. 별 x,y 등록
// 2. 각 별들의 dist를 저장하는 List 생성
// 3. 배열로 다 연결되었는지 체크 (첫 번째 별에서 부터 시작)
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    // 입력
    val n = readLine().toInt()
    val stars = mutableListOf<Star>()

    repeat(n) { index ->
        val (x, y) = readLine().split(" ").map { it.toFloat() * 100 }.map { it.toInt() }
        stars.add(Star(index, x, y))
    }

    val distAdj = Array(n) { mutableListOf<Dist>() }
    for (i in 0 until n) {
        val star = stars[i]
        for (j in 0 until n) {
            if (i == j) continue
            val weight = calcWeight(star, stars[j])
            distAdj[i].add(Dist(j, weight))
            distAdj[j].add(Dist(i, weight))
        }
    }

    // 첫 번째 별을 기준으로 탐색 시작
    val queue = ArrayDeque<Int>(n)
    queue.add(0)

    val weightArr = IntArray(n) { Int.MAX_VALUE }
    weightArr[0] = 0

    val visited = BooleanArray(n)
    visited[0] = true

    var res = 0
    while (true) {
        val idx = queue.removeFirst()

        for (dist in distAdj[idx]) {
            if (weightArr[dist.starIdx] < dist.weight) continue
            weightArr[dist.starIdx] = dist.weight
        }

        var minWeightIdx = -1
        for (i in 0 until n) {
            if (visited[i]) continue
            if (weightArr[i] == Int.MAX_VALUE) continue
            if (minWeightIdx == -1) minWeightIdx = i
            if (weightArr[minWeightIdx] > weightArr[i]) {
                minWeightIdx = i
            }
        }
        if (minWeightIdx == -1) break
        visited[minWeightIdx] = true
        res += weightArr[minWeightIdx]
        queue.add(minWeightIdx)
    }

    println(res.toFloat()/100)
}

fun calcWeight(star1: Star, star2: Star): Int {
    return Math.sqrt(Math.pow((star1.x - star2.x).toDouble(), 2.0) + Math.pow((star1.y - star2.y).toDouble(), 2.0)).toInt()
}

data class Star(
    val idx: Int,
    val x: Int,
    val y: Int
)

data class Dist(
    val starIdx: Int,
    val weight: Int
)