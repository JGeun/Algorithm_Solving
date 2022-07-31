class Solution {
    fun solution(new_id: String) = new_id.toLowerCase()
        .filter { it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.' }
        .replace("[.]*[.]".toRegex(), ".")
        .removePrefix(".").removeSuffix(".")
        .let { if (it.isEmpty()) "a" else it }
        .let { if (it.length > 15) it.substring(0, 15) else it }.removeSuffix(".")
        .let {
            if (it.length <= 2) {
                var answer = it
                do {
                    answer += answer[answer.length-1]
                } while (answer.length < 3)
                answer
            } else it
        }
}