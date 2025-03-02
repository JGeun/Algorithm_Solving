const val MAX_NUM = 1_000_000

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val era = getEra()
    val n = readLine().toInt()
    for (i in 0 until n) {
        val num = readLine().toInt()

        var res = 0
        for (j in 1 .. num / 2) {
            if (era[j].not() || era[num-j].not()) continue
            res += 1
        }
        println(res)
    }
}

private fun getEra(): BooleanArray {
    val era = BooleanArray(MAX_NUM+1) { true }
    era[0] = false
    era[1] = false
    for (i in 2 .. MAX_NUM) {
        for (j in 2 .. MAX_NUM / i) {
            era[i * j] = false
        }
    }
    return era
}

