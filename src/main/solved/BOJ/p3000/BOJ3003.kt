import java.util.*

fun main() {
    val piece = intArrayOf(1, 1, 2, 2, 2, 8)
    val nums = readLine()!!.split(" ")

    for (i in nums.indices) {
        print(String.format("%d ", piece[i] - nums[i].toInt()))
    }
}