fun main() = with(System.`in`.bufferedReader()) {
  val N = readLine().toInt()
  val nums = readLine().split(" ").map { it.toInt() }
  val findNum = readLine().toInt()
  println("${nums.count { it == findNum }}")
}
