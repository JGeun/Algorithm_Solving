package BOJ.JGeun.p2900;

import java.io.*;
import java.util.Arrays;

public class BOJ2981{
    public static int getGCD(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void printDivisor(int n){
        for(int i=2; i<=n; i++){
            if(n%i == 0)
                System.out.print(i+" ");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int gcd = arr[1]-arr[0];
        for(int i=2; i<arr.length; i++)
            gcd = getGCD(gcd, arr[i]-arr[i-1]);

        printDivisor(gcd);
    }
}
