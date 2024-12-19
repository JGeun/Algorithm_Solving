import java.util.*;

class Solution {
    public String solution(String rny_string) {
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<rny_string.length(); i++) {
            char ch = rny_string.charAt(i);
            if (ch == 'm') {
                sb.append("rn");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}