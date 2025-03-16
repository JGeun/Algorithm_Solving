fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    // Input
    val N: Int = 5
    val M: Int = 15
    val arr = Array<CharArray>(N) { CharArray(M) { '*' } }

    repeat (N) {
        val line = readLine().toCharArray()
        for (i in line.indices) {
            arr[it][i] = line[i]
        }
    }

    // ABCDE***********
    // abcde***********
    // 01234***********

    // Solve
    // 가로를 기준으로
    val sb = StringBuilder()
    for (j in 0 until M) {
        // 세로 반복
        for (i in 0 until N) {
            sb.append(arr[i][j])
        }
    }

    println(sb.toString().replace("*", ""))
}