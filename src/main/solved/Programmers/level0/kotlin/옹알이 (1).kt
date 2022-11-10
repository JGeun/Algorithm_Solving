import java.util.*

class Solution {
    private val wordSet = HashSet<String>()
    private val words = arrayOf("aya", "ye", "woo", "ma")

    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0

        makeCase(0, "", Array(5){i -> false})

        for (b in babbling) {
            if (wordSet.contains(b)) {
                answer += 1
            }
        }
        return answer
    }

    private fun makeCase(start: Int, word: String, visited: Array<Boolean>) {
        if (start == 4) {
            wordSet.add(word)
            return
        }

        for (i in 0 until 4) {
            if (!visited[i]) {
                visited[i] = true
                wordSet.add(word)
                makeCase(start+1, word+words[i], visited)
                visited[i] = false
            }
        }

    }
}