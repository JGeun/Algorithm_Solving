import java.util.*

class Solution {
    fun solution(code: String): String {
        val sb = StringBuilder()
        var mode = 0
        
        for (i in 0 until code.length) {
            val ch = code[i]
            if (ch == '1') {
                mode = if (mode == 0) 1 else 0
                continue
            }
            
            if (i % 2 == mode) {
                sb.append(ch)
            }
        }
        
        return if (sb.isNotEmpty()) {
            sb.toString()
        } else {
            "EMPTY"
        }
    }
}