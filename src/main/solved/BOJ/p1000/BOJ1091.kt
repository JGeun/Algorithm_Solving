fun main() {
    val n = readLine()!!.toInt()
    val p = readLine()!!.split(" ").map { it.toInt() }.toList()
    val s = readLine()!!.split(" ").map { it.toInt() }.toList()
    val next = p.toMutableList()

    var ans = 0
    while(true) {
        if (isValidationOrder(next)) {
            break;
        }

        ans += 1
        shuffle(next, s)

        if (isOriginalSame(p, next)) {
            ans = -1;
            break;
        }
    }
    println(ans)
}

fun shuffle(next: MutableList<Int>, s: List<Int>) {
    val temp = arrayOfNulls<Int>(s.size)

    for (i in next.indices) {
        temp[s[i]] = next[i]
    }

    for (i in next.indices) {
        next[i] = temp[i] ?: -1
    }
}

fun isValidationOrder(next: MutableList<Int>): Boolean {
    for (i in 0 until next.size) {
        if (next[i] != i%3) return false
    }
    return true;
}

fun isOriginalSame(p: List<Int>, next: List<Int>): Boolean {
    for (i in p.indices) {
        if (p[i] != next[i]) {
            return false;
        }
    }
    return true;
}