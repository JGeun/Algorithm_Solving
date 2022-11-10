class Solution {
    fun solution(dots: Array<IntArray>): Int {

        dots.sortWith(Comparator<IntArray> {d1, d2 ->
            if (d1[0] != d2[0]) d1[0] - d2[0]
            else d1[1] - d2[1]
        })

        val slope = (dots[0][1] - dots[1][1]).toDouble()/(dots[0][0] - dots[1][0]).toDouble();
        val slope1 = (dots[2][1] - dots[3][1]).toDouble()/(dots[2][0] - dots[3][0]).toDouble();

        if (slope == slope1) return 1;

        val slope2 = (dots[0][1] - dots[2][1]).toDouble()/(dots[0][0] - dots[2][0]).toDouble();
        val slope3 = (dots[1][1] - dots[3][1]).toDouble()/(dots[1][0] - dots[3][0]).toDouble();

        if (slope2 == slope3) return 1;

        val slope4 = (dots[0][1] - dots[3][1]).toDouble()/(dots[0][0] - dots[3][0]).toDouble();
        val slope5 = (dots[1][1] - dots[2][1]).toDouble()/(dots[1][0] - dots[2][0]).toDouble();

        return 0
    }
}