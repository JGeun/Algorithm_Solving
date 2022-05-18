import java.util.*;

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        String id = "";
        for(int i=0; i<new_id.length(); i++){
            char ch = new_id.charAt(i);
            if((ch >= 'a' && ch <= 'z') || (ch >='0' && ch<='9') || ch == '-' || ch == '_' || ch == '.')
                id += new_id.substring(i, i+1);
        }
        while(id.contains("..")){
            id = id.replace("..", ".");
        }

        if(id.length() >= 1 && id.charAt(0) == '.')
            id = id.substring(1, id.length());

        if(id.length() >= 1 && id.charAt(id.length()-1) == '.')
            id = id.substring(0, id.length()-1);

        if(id.length() == 0)
            id += "a";

        if(id.length() >= 16){
            id = id.substring(0, 15);
            if(id.charAt(14) == '.')
                id = id.substring(0, 14);
        }

        if(id.length() <= 2){
            while(id.length() != 3){
                id += id.substring(id.length()-1, id.length());
            }
        }

        return id;
    }
}