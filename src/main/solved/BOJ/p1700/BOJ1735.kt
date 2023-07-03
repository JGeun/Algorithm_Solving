fun main() {
    val nums = readLine()!!.split(" ").map { num -> Integer.parseInt(num) }
    val nums2 = readLine()!!.split(" ").map { num -> Integer.parseInt(num) }
    val x = nums[0] * nums2[1] + nums[1] * nums2[0]
    val y = nums[1] * nums2[1]
    val gcd = gcd(Math.max(x, y), Math.min(x, y))
    println("${x/gcd} ${y/gcd}")
}

fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a