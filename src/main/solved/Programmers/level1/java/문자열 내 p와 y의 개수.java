class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int pCount=0;
        int yCount=0;

        String word = s.toLowerCase();
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) == 'p')
                pCount++;
            else if(word.charAt(i) == 'y')
                yCount++;
        }
        if(pCount == yCount)
            answer = true;
        else
            answer = false;
        return answer;
    }
}