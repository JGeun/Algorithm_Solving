package BOJ.p10600;

import java.io.*;
import java.util.*;

public class BOJ10610 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static List<Integer> numList = new ArrayList();
    static String n;

    static void input() throws IOException {
        n = br.readLine();
    }

    static void process(){
        int sum = 0;

        for(int i=0; i<n.length(); i++) {
            int num = n.charAt(i)-'0';
            numList.add(num);
            sum+=num;
        }

        Collections.sort(numList);

        if(numList.get(0) ==0  && sum % 3 == 0) {
            for (int i = numList.size() - 1; i >= 0; i--) sb.append(numList.get(i));
            System.out.println(sb);
        }
        else System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
