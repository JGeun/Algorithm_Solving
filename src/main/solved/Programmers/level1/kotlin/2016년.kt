class Solution {
    fun solution(a: Int, b: Int): String {
        val week = arrayOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
        val month = arrayOf(0, 31, 29, 31, 30, 31, 30 ,31, 31, 30, 31, 30, 31)
        var days = 0
        for(i in 1 until a) days+=month[i];
        days += b
        days %= 7
        return week[(days+4)%7]
    }
}