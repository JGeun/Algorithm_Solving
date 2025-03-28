import java.util.PriorityQueue
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val pq = PriorityQueue<Int> { a, b ->
        val absA = abs(a)
        val absB = abs(b)
        if (absA != absB) absA - absB else a - b
    }

    val sb = StringBuilder()

    repeat(n) {
        val num = readLine().toInt()
        if (num != 0) {
            pq.add(num)
        } else {
            sb.append(pq.poll() ?: 0).append('\n')
        }
    }

    print(sb)
}