import java.util.*

fun main() {
    val N = readLine()!!.toInt()
    var ans = 0
    var idx = 1

    while (idx <= N) {
        ans += N - (idx-1)
        idx *= 10
    }
    println(ans)
}