import java.util.*;
import java.io.*;

// 10분 15초
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        for (int i=0; i<str.length(); i++) {
            int num = str.charAt(i) - '0';
            int oct = Integer.valueOf(str.substring(i, i + 1), 8);
            String binary = Integer.toBinaryString(oct);
            if (i != 0) {
                sb.append("0".repeat(Math.max(0, 3 - binary.length())));
            }
            sb.append(binary);
        }
        System.out.println(sb);
    }
}