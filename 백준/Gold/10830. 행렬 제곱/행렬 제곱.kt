fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val inputs = readLine().split(" ")
    val N = inputs[0].toInt()
    val B = inputs[1].toLong()

    val arr = Array(N.toInt()) { readLine().split(" ").map { it.toInt() % 1000 }.toIntArray() }

    val result = divide(arr, B, B)
    result.forEach { a ->
        a.forEach { b ->
            print("$b ")
        }
        println()
    }
}

fun divide(sub: Array<IntArray>, p: Long, B: Long): Array<IntArray> {
    if (p == 1L) return sub

    val divideRes = divide(sub, p/2, B)
    return if (p % 2 == 0L) {
        calcArr(divideRes, divideRes)
    } else {
        calcArr(calcArr(divideRes, divideRes), sub)
    }
}

fun calcArr(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
    return Array(arr1.size) { i ->
        IntArray(arr2[0].size){ j ->
            var value = 0L
            // arr1의 열의 개수만큼 반복 or arr2의 행의 개수만큼 반복
            for(k in arr2.indices){
                value += arr1[i][k] * arr2[k][j].toLong()
            }
            // 계산된 결과의 원소값을 반환
            (value % 1000).toInt()
        }
    }
}