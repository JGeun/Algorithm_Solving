class Solution {
    fun solution(x: Int, n: Int): LongArray {
        return LongArray(n){ i-> (x.toLong() * (i+1))}
    }
}