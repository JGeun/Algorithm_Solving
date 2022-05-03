class Solution {
    fun solution(num: Int): Int {
        var n : Long = num.toLong()
        var answer = 0
        while(n != 1L){
            if (answer == 500){
                return -1;
            }

            if (n % 2 == 0L) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            answer += 1
        }

        return answer
    }
}