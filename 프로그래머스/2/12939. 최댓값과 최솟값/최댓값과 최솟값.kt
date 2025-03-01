class Solution {
    fun solution(s: String): String {
        val nums = s.split(" ").map { it.toInt() }.sorted()
        return "${nums[0]} ${nums[nums.size-1]}"
    }
}