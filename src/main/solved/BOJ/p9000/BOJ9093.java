import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();

        while(T-->0) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    sb.append(str.charAt(i));
                } else {
                    ans.append(sb.reverse()).append(' ');
                    sb = new StringBuilder();
                }
            }
            ans.append(sb.reverse()).append('\n');
        }
        System.out.print(ans);
    }
}