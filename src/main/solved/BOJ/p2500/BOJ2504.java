import java.io.*;
import java.util.*;

public class Main {

    private static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int res = 0, value = 1;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                value *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                value *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    res = 0;
                    break;
                } else if (line.charAt(i-1) == '(') {
                    res += value;
                }
                stack.pop();
                value /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    res = 0;
                    break;
                } else if (line.charAt(i-1) == '[') {
                    res += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        System.out.println(stack.isEmpty() ? res : 0);
    }
}