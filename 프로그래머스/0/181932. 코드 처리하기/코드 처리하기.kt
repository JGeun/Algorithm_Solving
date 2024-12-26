import java.util.*

class Solution {
    fun solution(code: String): String {
        val sb = StringBuilder()
        var mode = 0
        
        code.forEachIndexed { index, ch ->
            if(ch == '1') mode = mode xor 1
            else if (index % 2 == mode) {
                sb.append(ch);
            }
        }
        
        return if (sb.isNotEmpty()) {
            sb.toString()
        } else {
            "EMPTY"
        }
    }
}