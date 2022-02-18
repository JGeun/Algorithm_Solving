package BOJ.p1400;

import java.io.*;
import java.util.*;

public class BOJ1439 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static String S;

    static void input() throws IOException {
        S = br.readLine();
    }

    static void process(){
        System.out.println(Math.min(getTypeCnt('0'), getTypeCnt('1')));
    }

    static int getTypeCnt(char type){
        boolean isSame = false;
        int cnt = 0;

        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == type){
                if(!isSame){
                    isSame = true;
                    cnt +=1;
                }
            }else{
                isSame = false;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
