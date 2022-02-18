package BOJ.p1300;

import java.io.*;
import java.util.*;

public class BOJ1394 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");
    static StringBuilder sb = new StringBuilder("");

    static final int MOD = 900528;
    static Code[] codes;
    static String computerCode;

    static void input() throws IOException {
        String[] line = br.readLine().split("");
        codes = new Code[line.length];
        for(int i=0; i<line.length; i++) codes[i] = new Code(line[i], i+1);
        Arrays.sort(codes);
        computerCode = br.readLine();
    }

    static void process() {
        long ans = 0;
        for(int i=0; i<computerCode.length(); i++){
            ans = (ans * codes.length + findStr(computerCode.substring(i, i+1))) % MOD;
        }
        System.out.println(ans%MOD);
    }

    static int findStr(String str){
        int L = 0, R = codes.length-1, pos=R;
        while(L<=R){
            int mid = (L+R)/2;
            if(str.compareTo(codes[mid].str) < 0){
                R = R-1;
                pos = R;
            }else{
                L = L+1;
            }
        }
        return codes[pos].idx;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static class Code implements Comparable<Code>{
        String str;
        int idx;

        Code(String str, int idx){
            this.str = str; this.idx = idx;
        }

        @Override
        public int compareTo(Code c) {
            if(!this.str.equals(c.str)) return this.str.compareTo(c.str);
            return this.idx - c.idx;
        }

        @Override
        public boolean equals(Object object){
            Code code = (Code)object;
            if(this.str.equals(code.str)) return true;
            return false;
        }
    }
}
