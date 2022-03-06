package BOJ.p2000;

import java.io.*;
import java.util.*;

public class BOJ2012{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] grade = new int[N+1];

        for(int i=1; i<=N; i++)
            grade[i] = Integer.parseInt(br.readLine());
        Arrays.sort(grade);

        long ans = 0;
        for(int i=1; i<=N; i++)
            ans += Math.abs(grade[i]-i);
        System.out.println(ans);
    }
}