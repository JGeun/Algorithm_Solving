class Solution {
    fun solution(new_id: String): String {
        // 1단계
        var id: String = new_id.toLowerCase()

        // 2단계
        var answer: String = ""
        for (i in 0 until id.length) {
            answer += removeWord(id[i]) ?: ""
        }

        // 3단계
        while (answer.contains("..")) {
            answer = answer.replace("..", ".")
        }

        // 4단계
        answer = answer.removePrefix(".").removeSuffix(".")

        // 5단계
        if (answer.length == 0) answer = "a"

        // 6단계
        if (answer.length >= 16) answer = answer.substring(0, 15)
        answer = answer.removeSuffix(".")

        // 7단계
        if (answer.length <= 2) {
            do {
                answer += answer[answer.length-1]
            } while(answer.length < 3);
        }

        return answer
    }

    private fun removeWord(ch: Char) : Char? {
        if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == '-' || ch == '_' || ch == '.') return ch
        else return null
    }
}