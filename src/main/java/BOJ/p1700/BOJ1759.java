package BOJ.p1700;

import java.io.*;
import java.util.*;

public class BOJ1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int L, C;
    static String[] alpha;
    static int[] visit;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visit = new int[L+1];
        alpha = new String[C+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=C; i++) alpha[i] = st.nextToken();
    }

    static void findCase(int index, int vCnt, int mCnt){
        if(index == L){
            if(vCnt >= 1 && mCnt>=2){
                for(int i=1; i<=L; i++) sb.append(alpha[visit[i]]);
                sb.append('\n');
            }
            return;
        }

        for(int i=visit[index]+1; i<=C; i++){
            visit[index+1] = i;
            if(isCheckVowel(alpha[i])) findCase(index+1, vCnt+1, mCnt);
            else findCase(index+1, vCnt, mCnt+1);
            visit[index+1] = 0;
        }
    }

    static boolean isCheckVowel(String ch){
        if(ch.equals("a") || ch.equals("e") || ch.equals("i") || ch.equals("o") || ch.equals("u")) return true;
        return false;
    }

    static void process(){
        Arrays.sort(alpha, 1, C+1);
        findCase(0, 0, 0);
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
