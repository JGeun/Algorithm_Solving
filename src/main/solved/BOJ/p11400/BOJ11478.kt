fun main() {
    val s = readLine()!!
    val subset = HashSet<String>()

    for (i in s.indices) {
        for (j in i+1..s.length) {
            subset.add(s.substring(i, j))
        }
    }
    println(subset.size)
}