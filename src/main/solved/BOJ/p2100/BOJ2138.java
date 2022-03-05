package BOJ.p2100;

import java.io.*;
import java.util.*;

public class BOJ2138 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, ans1 = 0, ans2 = 0;
    static int[] light1, light2, status;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        light1 = new int[N+1];
        light2 = new int[N+1];
        status = new int[N+1];
        String line1 = br.readLine();
        String line2 = br.readLine();
        for(int i=0; i<line1.length(); i++){
            int num = Integer.parseInt(line1.substring(i, i + 1));
            light1[i+1] = num; light2[i+1] = num;
            status[i+1] = Integer.parseInt(line2.substring(i, i+1));
        }
    }

    private static void process() throws IOException{
        if(status[1] == 1){
            lightSwitch(light2, 1);
            ans2 +=1;
        }else{
            lightSwitch(light1, 1);
            ans1 +=1;
        }

        for(int i=2; i<=N; i++){
            if(status[i-1] != light1[i-1]){
                lightSwitch(light1, i); ans1+=1;
            }
            if(status[i-1] != light2[i-1]){
                lightSwitch(light2, i); ans2 += 1;
            }
        }

        if(!isSame(status, light1)) ans1 = Integer.MAX_VALUE;
        if(!isSame(status, light2)) ans2 = Integer.MAX_VALUE;

        if(ans1 == Integer.MAX_VALUE && ans2 == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(Math.min(ans1, ans2));
    }

    private static void lightSwitch(int[] light, int n) {
        if(n != 1) light[n-1] = swap(light[n-1]);
        light[n] = swap(light[n]);
        if(n != N) light[n+1] = swap(light[n+1]);
    }

    private static int swap(int n){
        return n == 0 ? 1 : 0;
    }

    private static boolean isSame(int[] light, int[] status){
        for(int i=1; i<=N; i++)
            if(light[i] != status[i]) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
