import java.io.*;
import java.util.*;

// 6분 30초
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Stack<Character>> stacks = new ArrayList<>();
        for (int i=0; i<5; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack();
            for (int j=str.length()-1; j>=0; j--) {
                stack.push(str.charAt(j));
            }
            stacks.add(stack);
        }

        StringBuilder sb = new StringBuilder();
        while(true) {
            boolean isEmpty = true;
            for (int i=0; i<5; i++) {
                if(!stacks.get(i).isEmpty()) {
                    isEmpty = false;
                    sb.append(stacks.get(i).pop());
                }
            }

            if (isEmpty) break;
        }
        System.out.println(sb);
    }
}