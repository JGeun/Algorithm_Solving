fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val T =  readLine().toInt()
    val sb = StringBuilder()

    repeat(T) {
        val N = readLine().toInt()
        val nums = IntArray(N + 1) // 1-based index 사용
        readLine().split(" ").mapIndexed { index, value -> nums[index + 1] = value.toInt() }
        sb.append(findCycleCount(N, nums)).append("\n")
    }

    print(sb)
}

fun findCycleCount(N: Int, nums: IntArray): Int {
    var count = 0
    val visited = BooleanArray(N + 1)

    for (i in 1..N) {
        if (!visited[i]) {
            dfs(nums, i, visited)
            count++
        }
    }
    return count
}

fun dfs(nums: IntArray, node: Int, visited: BooleanArray) {
    if (visited[node]) return
    visited[node] = true
    dfs(nums, nums[node], visited)
}



// 1 2 3 4 5 6 7 8 9 10
// 2 1 3 4 5 6 7 9 10 8

// 1 -> 2 -> 1
// 3 -> 3
// 4 -> 4
// 5 -> 5
// 6 -> 6
// 7 -> 7
// 8 -> 9 -> 10 -> 8