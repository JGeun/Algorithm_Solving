fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    for(i in 0 until b){
        for(j in 0 until a)
            print("*")
        println()
    }
}