import java.lang.*


fun main() = with(System.`in`.bufferedReader()) {
  val K = readLine().toInt()
  val numList = readLine().split(" ").map { it.toInt() }
  val tree = Array<MutableList<Int>>(K) { mutableListOf() }

  fun searchTree(numList: List<Int>, left: Int, right: Int, level: Int) {
    val mid = (left + right) / 2
    tree[level].add(numList[mid])

    if (mid == left) return
    searchTree(numList, left, mid, level+1)
    searchTree(numList, mid+1, right, level+1)
  }

  searchTree(numList, 0, numList.size, 0)
  val sb = StringBuilder()
  for (layer in tree) {
    for (num in layer) {
      sb.append(num).append(" ")
    }
    sb.append("\n")
  }
  print(sb)
}
