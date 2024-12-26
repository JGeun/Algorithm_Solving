fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val sb = StringBuilder()

    repeat (N / 4) {
        sb.append("long ")
    }
    sb.append("int")

    println(sb)
}