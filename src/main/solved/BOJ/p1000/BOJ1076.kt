import java.util.*

fun main() {
    val colorMap = HashMap<String, IntArray>()
    colorMap.put("black", intArrayOf(0, 1))
    colorMap.put("brown", intArrayOf(1, 10))
    colorMap.put("red", intArrayOf(2, 100))
    colorMap.put("orange", intArrayOf(3, 1000))
    colorMap.put("yellow", intArrayOf(4, 10000))
    colorMap.put("green", intArrayOf(5, 100000))
    colorMap.put("blue", intArrayOf(6, 1000000))
    colorMap.put("violet", intArrayOf(7, 10000000))
    colorMap.put("grey", intArrayOf(8, 100000000))
    colorMap.put("white", intArrayOf(9, 1000000000))

    val first: Int = colorMap[readLine()]!![0]
    val second: Int = colorMap[readLine()]!![0]
    val third: Int = colorMap[readLine()]!![1]

    println((first * 10L + second) * third)
}