fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val N = readLine().toInt()
    val nums = readLine().split(" ").map { it.toInt() }

    // 해당 숫자 이전에 선택한 index를 저장
    val prevIndexArr = IntArray(N) { -1 }
    val dp = IntArray(N) { 1 }
    dp[0] = 1

    var maxIndex = 0
    for (i in 1 until N) {
        for (j in 0 until i) {
            // 이전의 값중 가장 큰 dp값을 가지는 것을 저장
            if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                prevIndexArr[i] = j
                dp[i] = dp[j] + 1
            }
        }
        // 가장 dp값이 높은 것을 저장
        if (dp[maxIndex] < dp[i]) {
            maxIndex = i
        }
    }

    println(dp[maxIndex])
    val sb = StringBuilder()
    var printIndex = maxIndex
    while (true) {
        sb.insert(0, nums[printIndex])
        if (prevIndexArr[printIndex] == -1) break
        sb.insert(0, " ")
        printIndex = prevIndexArr[printIndex]
    }
    println(sb)
}
