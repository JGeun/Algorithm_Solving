fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val str1 = readLine()
    val str2 = readLine()
    val dp = Array(str1.length+1) { IntArray(str2.length+1) }

    var res = 0
    for (i in 1 .. str1.length) {
        for (j in 1 .. str2.length) {
            if (str1[i-1] == str2[j-1]) {
                dp[i][j] = dp[i-1][j-1]+1
            } else {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
            }
            res = Math.max(dp[i][j], res)
        }
    }

    println(res)
}
