import java.io.*;
import java.util.*;

// 10분 44초
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack();
        boolean isTag = false;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '<') {
                isTag = true;
                ans.append(ch);
            } else if (ch == '>') {
                isTag = false;
                ans.append(ch);
            } else if (ch == ' ') {
                ans.append(ch);
            }
            else {
                if (isTag) {
                    ans.append(ch);
                } else {
                    stack.push(ch);
                    if (i + 1 < S.length() && (S.charAt(i + 1) == ' ' || S.charAt(i + 1) == '<')) {
                        while(!stack.isEmpty()) {
                            ans.append(stack.pop());
                        }
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        System.out.println(ans);
    }
}