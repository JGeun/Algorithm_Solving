fun main() {
    val N = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { num -> num.toInt() }
    val dp = IntArray(N+100) { Integer.MAX_VALUE }
    dp[0] = 0

    for (i in 0 until N) {
        if (dp[i] >= Integer.MAX_VALUE) continue
        for (j in 1..arr[i]) {
            dp[i+j] = Math.min(dp[i+j], dp[i]+1)
        }
    }

    println(if(dp[N-1] >= Integer.MAX_VALUE) -1 else dp[N-1])
}
