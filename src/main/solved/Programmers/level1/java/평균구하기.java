package Programmers.level1.java;

class Solution {
    public double solution(int[] arr) {
        int sum = 0;
        for(int num : arr)
            sum += num;
        return (double)sum/arr.length;
    }
}
