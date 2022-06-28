import java.io.*;
import java.util.*;

public class Main {
    private static Stack<Character> s = new Stack<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int ans = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(' && line.charAt(i+1) == ')') {
                ans += s.size();
                i += 1;
            } else if (line.charAt(i) == ')') {
                ans += 1;
                s.pop();
            } else {
                s.push('(');
            }
        }
        System.out.println(ans + s.size());
    }
}