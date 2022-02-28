package Programmers.level2.java;

class Solution {
    public int solution(int[] numbers, int target) {
        return findCase(numbers, 0, 0, target);
    }

    private int findCase(int[] numbers, int cnt, int sum, int target){
        if(cnt == numbers.length){
            if(sum == target) return 1;
            return 0;
        }

        return findCase(numbers, cnt+1, sum+numbers[cnt], target)
                + findCase(numbers, cnt+1, sum-numbers[cnt], target);
    }
}
