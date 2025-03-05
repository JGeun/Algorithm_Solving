lateinit var adj: Array<MutableList<Int>>
lateinit var parent: IntArray
lateinit var visited: BooleanArray

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    adj = Array(N+1) { mutableListOf<Int>() }

    for (i in 0 until N-1) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        adj[a].add(b)
        adj[b].add(a)
    }

    parent = IntArray(N+1).apply { this[1] = -1 }
    visited = BooleanArray(N+1)

    bfs(1)
    println(parent.slice(2..parent.lastIndex).joinToString("\n"))
}

fun bfs(node: Int) {
    val queue = ArrayDeque<Int>()
    queue.add(1)
    visited[1] = true
    parent[1] = -1

    while (queue.isNotEmpty()) {
        val curNode = queue.removeLast()

        for (child in adj[curNode]) {
            if (visited[child]) continue
            visited[child] = true
            parent[child] = curNode
            queue.add(child)
         }
    }
}