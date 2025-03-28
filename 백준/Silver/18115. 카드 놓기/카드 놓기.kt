fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val A = readLine().split(" ").map { it.toInt() }

    val deque = ArrayDeque<Int>()

    var cardNum = 1
    for (i in N - 1 downTo 0) {
        when (A[i]) {
            1 -> deque.addFirst(cardNum)
            2 -> {
                val first = deque.removeFirstOrNull()
                deque.addFirst(cardNum)
                if (first != null) deque.addFirst(first)
            }
            3 -> deque.addLast(cardNum)
        }
        cardNum++
    }

    println(deque.joinToString(" "))
}