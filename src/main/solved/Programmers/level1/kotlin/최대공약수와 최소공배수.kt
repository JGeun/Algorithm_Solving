class Solution {
    fun solution(n: Int, m: Int): IntArray {
        val max = Math.max(n, m)
        val min = Math.min(n, m)
        return intArrayOf(gcd(max, min), gcm(max, min))
    }

    fun gcd(a : Int, b : Int) : Int{
        if(b == 0) {
            return a
        }
        else {
            return gcd(b, a%b)
        }
    }

    fun gcm(a : Int, b : Int) : Int{
        return (a * b / gcd(a, b))
    }
}
