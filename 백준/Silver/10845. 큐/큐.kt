import java.util.Stack

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val N = readLine().toInt()
    val sb = StringBuilder()
    val queue = ArrayDeque<Int>()

    repeat (N) {
        val input = readLine().split(" ")

        when (input[0]) {
            "push" -> {
                val num = input[1].toInt()
                queue.addLast(num)
            }
            "pop" -> {
                val removed = queue.removeFirstOrNull() ?: -1
                sb.append(removed).append("\n")
            }
            "size" -> {
                sb.append(queue.size).append("\n")
            }
            "empty" -> {
                sb.append(if(queue.isEmpty()) 1 else 0).append("\n")
            }
            "front" -> {
                val front = queue.firstOrNull() ?: -1
                sb.append(front).append("\n")
            }
            "back" -> {
                val back = queue.lastOrNull() ?: -1
                sb.append(back).append("\n")
            }
            else -> {}
        }
    }

    println(sb)
}