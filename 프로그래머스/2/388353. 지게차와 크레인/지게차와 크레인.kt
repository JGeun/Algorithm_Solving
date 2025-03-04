/**
 * 테두리에 있는 블록은 access true
 * 1. 단일 문자인 경우 - 전체 반복문을 돌면서 access인 경우만 제거
 * 2. 2글자인 경우는 다 지움
 * 핵심: 각 단계마다 dfs를 통해서 access 다 체크해줘야 함.
 */
class Solution {
    private var h = 0
    private var w = 0
    private val mh get() = h + 2
    private val mw get() = w + 2

    private lateinit var map: Array<CharArray>
    private lateinit var access: Array<BooleanArray>
    private val dx = intArrayOf(-1, 1, 0, 0)
    private val dy = intArrayOf(0, 0, -1, 1)

    fun solution(storage: Array<String>, requests: Array<String>): Int {
        h = storage.size
        w = storage.getOrNull(0)?.length ?: 0

        map = createMap(storage)
        access = createAccess()
        checkAccess()

        for (request in requests) {
            if (request.length == 1) solveSingleWord(request[0])
            else solveDoubleWord(request[0])
            checkAccess()
        }

        return map.sumOf { row -> row.count { it != '*' } }
    }

    private fun printMap() = map.forEach { println(it.joinToString(" ")) }
    private fun printAccess() = access.forEach { println(it.joinToString(" ")) }

    private fun checkAccess() {
        val visited = Array(mh) { BooleanArray(mw) }
        val checkAccess = createEmptyAccess()

        for (x in 0 until mh) {
            for (y in 0 until mw) {
                if (!access[x][y] || map[x][y] != '*') continue
                visited[x][y] = true
                checkAccessDfs(x, y, visited, checkAccess)
            }
        }

        for (x in 0 until mh) {
            for (y in 0 until mw) {
                if (checkAccess[x][y]) access[x][y] = true
            }
        }
    }

    private fun checkAccessDfs(x: Int, y: Int, visited: Array<BooleanArray>, checkAccess: Array<BooleanArray>) {
        for (i in 0 until 4) {
            val fx = x + dx[i]
            val fy = y + dy[i]

            if (fx !in 0 until mh || fy !in 0 until mw || visited[fx][fy]) continue
            checkAccess[fx][fy] = true
            visited[fx][fy] = true
            if (map[fx][fy] == '*') checkAccessDfs(fx, fy, visited, checkAccess)
        }
    }

    private fun solveDoubleWord(word: Char) {
        for (i in 1 until mh) {
            for (j in 1 until mw) {
                if (map[i][j] == word) map[i][j] = '*'
            }
        }
    }

    private fun solveSingleWord(word: Char) {
        for (i in 1 until mh) {
            for (j in 1 until mw) {
                if (map[i][j] == word && access[i][j]) map[i][j] = '*'
            }
        }
    }

    private fun createEmptyAccess() = Array(mh) { BooleanArray(mw) }

    private fun createMap(storage: Array<String>) = Array(mh) { CharArray(mw) { '*' } }.apply {
        for (i in 0 until h) {
            for (j in 0 until w) {
                this[i + 1][j + 1] = storage[i][j]
            }
        }
    }

    private fun createAccess() = Array(mh) { BooleanArray(mw) }.apply {
        for (i in 0 until mh) {
            this[i][0] = true
            this[i][mw - 1] = true
        }
        for (j in 0 until mw) {
            this[0][j] = true
            this[mh - 1][j] = true
        }
    }
}