// 교차하지만 않으면 되므로 A, B에 대해 체크해서 중첩방문하지 않으면 좋은 단어
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()

    val stack = ArrayDeque<String>()
    var count = 0

    repeat(N) {
        val line = readLine().split("")

        for (ch in line) {
            if (stack.isEmpty()) {
                stack.add(ch)
            } else {
                val item = stack.last()

                if (item == ch) {
                    stack.removeLast()
                } else {
                    stack.addLast(ch)
                }
            }
        }

        if (stack.isEmpty()) {
            count += 1
        }

        stack.clear()
    }

    println(count)
}