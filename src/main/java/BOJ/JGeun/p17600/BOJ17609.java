package BOJ.JGeun.p17600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17609 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T;
    static String str;


    static void input() throws IOException {
        str = br.readLine();
    }

    static int process(int L, int R, int cnt){
        if(cnt == 2) return 2;

        while(L < R){
            if(str.charAt(L) != str.charAt(R)){
                int leftPalind = process(L+1, R, cnt+1);
                int rightPalind = process(L, R-1, cnt+1);
                return Math.min(leftPalind, rightPalind);
            }
            L+=1; R-=1;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            input();
            sb.append(process(0, str.length()-1, 0)).append('\n');
        }
        System.out.print(sb);
    }
}
