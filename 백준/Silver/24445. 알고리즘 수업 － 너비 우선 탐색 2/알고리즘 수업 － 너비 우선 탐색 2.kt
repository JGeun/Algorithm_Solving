import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M, R) = readLine().split(" ").map { it.toInt() }
    val adj = Array(N + 1) { mutableListOf<Int>() }

    repeat(M) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        adj[a].add(b)
        adj[b].add(a)
    }

    // 내림차순 정렬
    for (i in 1..N) {
        adj[i].sortDescending()
    }

    val queue: Deque<Int> = ArrayDeque()
    val visited = IntArray(N + 1) { 0 }
    var order = 1

    queue.add(R)
    visited[R] = order++

    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()

        for (next in adj[cur]) {
            if (visited[next] == 0) { // 방문하지 않은 노드만 추가
                visited[next] = order++
                queue.add(next)
            }
        }
    }

    println(visited.slice(1..N).joinToString("\n"))
}