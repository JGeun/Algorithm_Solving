class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        for(long i=left; i<=right; i++){
            answer[(int)(i-left)] = Math.max((int)(i%n),(int)(i/n))+1;
        }
        return answer;
    }
}