package BOJ.p5500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5525 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, M, patternCnt = 0;
    static char[] pattern;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        pattern = br.readLine().toCharArray();
    }

    static void process(){
        int ans = 0;
        for(int i=1; i<pattern.length-1; i++){
            if(pattern[i-1] == 'I' && pattern[i] == 'O' && pattern[i+1] == 'I'){
                patternCnt+=1;
                if(patternCnt == N){
                    patternCnt-=1;
                    ans += 1;
                }
                i++;
            }else{
                patternCnt = 0;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
