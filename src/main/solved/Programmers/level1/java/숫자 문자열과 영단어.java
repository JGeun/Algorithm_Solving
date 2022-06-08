class Solution {
    public int solution(String s) {
        for(int i=0; i<s.length(); i++){
            String ch = s.substring(i, i+1);
            switch(ch){
                case "z":
                    s = s.replace("zero", "0");
                    break;
                case "o":
                    s = s.replace("one", "1");
                    break;
                case "e":
                    s = s.replace("eight", "8");
                    break;
                case "n":
                    s = s.replace("nine", "9");
                    break;
                case "t":
                    if(s.substring(i, i+3).equals("two")){
                        s = s.replace("two", "2");
                    }else{
                        s = s.replace("three", "3");
                    }
                    break;
                case "f":
                    if(s.substring(i, i+4).equals("four")){
                        s = s.replace("four", "4");
                    }else{
                        s = s.replace("five", "5");
                    }
                    break;
                case "s":
                    if(s.substring(i, i+3).equals("six")){
                        s = s.replace("six", "6");
                    }else{
                        s = s.replace("seven", "7");
                    }
                    break;
            }
        }
        return Integer.parseInt(s);
    }
}