fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val trees = IntArray(n)
    for (i in 0 until n) {
        trees[i] = readLine().toInt()
    }
    trees.sort()

    var findMinGCD = trees[1] - trees[0];
    for (i in 1 until trees.size - 1) {
        findMinGCD = findMinGCD.coerceAtMost(getGCD(findMinGCD, trees[i+1] - trees[i]))
    }

    var answer = 0
    for (tree in trees.min() until trees.max() + 1 step findMinGCD) {
        answer += 1
    }
    println(answer - trees.size)
}

private fun getGCD(a: Int, b: Int): Int {
    if (b == 0) return a
    return getGCD(b, a%b)
}