package BOJ.p1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1259 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    private static boolean isPalind(String str) {
        for(int i=0; i<=str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        while(true){
            String str = br.readLine();
            if(str.equals("0")) break;
            if(isPalind(str)) sb.append("yes").append('\n');
            else sb.append("no").append('\n');
        }
        System.out.print(sb.toString());
    }
}
