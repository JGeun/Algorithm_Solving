package BOJ.JGeun.p1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static boolean[] breakdown = new boolean[10];

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        if(M != 0){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) breakdown[Integer.parseInt(st.nextToken())] = true;
        }
    }

    static void process(){
        int ans = pressPMBtn(100);

        for(int i=0; i<1000000; i++){
            String numStr = String.valueOf(i);
            if(!isBroken(numStr)){
                ans = Math.min(ans, pressPMBtn(i)+numStr.length());
            }
        }
        System.out.println(ans);
    }

    private static boolean isBroken(String numStr) {
        for(int i=0; i<numStr.length(); i++)
            if(breakdown[numStr.charAt(i)-'0']) return true;
        return false;
    }

    static int pressPMBtn(int num){
        return Math.abs(N-num);
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
