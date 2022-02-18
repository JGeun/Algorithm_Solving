package Programmers.level1.java;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch)){ //a
                sb.append((char)((ch-'a'+n)%26 + 'a'));
            }else if(Character.isUpperCase(ch)){ //A
                sb.append((char)((ch-'A'+n)%26 + 'A'));
            }else{
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
