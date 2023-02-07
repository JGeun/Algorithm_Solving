import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        solve();
    }

    private static void solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] chArr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char ch : chArr) {
            switch(ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while(!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());

    }

    public static int priority(char op) {
        if (op == '(' || op == ')') return 0;
        else if (op == '+' || op == '-') return 1;
        else if (op == '*' || op == '/') return 2;
        return -1;
    }
}
