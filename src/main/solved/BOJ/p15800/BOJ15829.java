package BOJ.p15800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15829 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, r=31, MOD = 1234567891;
    static String str;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
    }

    static void process(){
        long sum = 0;
        for(int i=0; i<str.length(); i++){
            int num = (str.charAt(i)-'a')+1;
            sum = (sum+getResult(num, i))%MOD;
        }
        System.out.println(sum);
    }

    static long getResult(int num, int cnt){
        long res = num;
        for (int i = 1; i <= cnt; i++)
            res = (res * r)%MOD;
        return res;
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}