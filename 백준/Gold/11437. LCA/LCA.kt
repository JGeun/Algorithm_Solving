import java.lang.*
import kotlin.text.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
  val N = readLine().toInt()
  val adj = Array<MutableList<Int>>(N+1) { mutableListOf() }
  val parents = IntArray(N+1) { it }

  repeat(N-1) {
    val (a, b) = readLine().split(" ").map { it.toInt() }
    adj[a].add(b)
    adj[b].add(a)
  }

  val levels = IntArray(N+1) { -1 }
  val visited = BooleanArray(N+1) { false }
  val queue = ArrayDeque<Int>()
  queue.add(1)
  visited[1] = true
  levels[1] = 1

  while (queue.isNotEmpty()) {
    val current = queue.removeFirst()

    for (node in adj[current]) {
      if (visited[node]) continue
      visited[node] = true
      parents[node] = current
      queue.add(node)
      levels[node] = levels[current] + 1
    }
  }

  val M = readLine().toInt()
  val sb = StringBuilder()

  repeat(M) {
    val (a, b) = readLine().split(" ").map { it.toInt() }
    var aParent = a
    var bParent = b

    while(levels[aParent] > levels[bParent]) {
      aParent = parents[aParent]
    }

    while(levels[aParent] < levels[bParent]) {
      bParent = parents[bParent]
    }

    while (aParent != bParent) {
      aParent = parents[aParent]
      bParent = parents[bParent]
    }
    sb.append(aParent).append("\n")
  }
  print(sb)
}