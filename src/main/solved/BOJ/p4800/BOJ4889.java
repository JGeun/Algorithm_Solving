import java.io.*;
import java.util.*;

public class Main {

    private static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int ans = 0, index = 1;

        while(true) {
            String line = br.readLine();
            if (line.contains("-")) {
                break;
            }

            sb.append(index++).append(". ");

            stack.clear(); ans = 0;
            for (int i=0; i<line.length(); i++) {
                char ch = line.charAt(i);
                if (!stack.isEmpty() && stack.peek() == '{' && ch == '}') {
                    stack.pop();
                } else {
                    stack.push(line.charAt(i));
                }
            }

            while(!stack.isEmpty()) {
                char second = stack.pop();
                char first = stack.pop();
                if (first != '{') ans += 1;
                if (second != '}') ans += 1;
            }

            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}