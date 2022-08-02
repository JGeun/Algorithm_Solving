class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer = IntArray(id_list.size)
        var reportCntList = IntArray(id_list.size)
        var idList = id_list.toList()
        var hashSet = HashSet<String>()

        for (r in report) hashSet.add(r)

        for (r in hashSet) {
            val str = r.split(" ")
            reportCntList[idList.indexOf(str[1])] +=1
        }

        for (r in hashSet) {
            val str = r.split(" ")
            if (reportCntList[idList.indexOf(str[1])] >= k) {
                answer[idList.indexOf(str[0])] += 1
            }
        }

        return answer
    }
}