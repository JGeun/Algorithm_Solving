class Solution {
    public int solution(int[] a) {

        int isNotAvailableCnt = 0;

        int[] minArr = new int[a.length];
        int min = Integer.MAX_VALUE;
        for (int i=a.length-1; i>=0; i--) {
            min = Math.min(min, a[i]);
            minArr[i] = min;
        }

        int left = Integer.MAX_VALUE;
        for (int i=0; i<a.length; i++) {
            if (left < a[i] && minArr[i] < a[i]) {
                isNotAvailableCnt += 1;
            }
            left = Math.min(left, a[i]);
        }
        return a.length - isNotAvailableCnt;
    }
}