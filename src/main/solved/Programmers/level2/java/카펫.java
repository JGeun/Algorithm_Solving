package Programmers.level2.java;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int maxHeight = (int)(Math.sqrt(brown+yellow));
        for(int i=3; i<=maxHeight; i++){
            int w = (brown+yellow)/i;
            int y = (w-2)*(i-2);
            int b = brown+yellow-y;
            if(brown == b && yellow == y){
                answer[0] = w; answer[1] = i;
                break;
            }
        }
        return answer;
    }
}