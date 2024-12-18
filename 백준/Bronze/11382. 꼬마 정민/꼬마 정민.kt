fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    println(
        readLine().split(" ").sumOf { it.toLong() }
    )
}