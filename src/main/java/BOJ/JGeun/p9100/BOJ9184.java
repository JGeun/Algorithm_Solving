package BOJ.JGeun.p9100;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ9184 {
    static int[][][] dp = new int[21][21][21];

    public static int getFunc(int a, int b, int c){

        if(a<=0 || b <=0 || c <= 0)
            return 1;
        else if(a>20 || b>20 || c> 20)
            return getFunc(20, 20, 20);
        else if(dp[a][b][c] != 0)
            return dp[a][b][c];
        else if(a<b && b<c)
            return dp[a][b][c] = getFunc(a, b, c-1) + getFunc(a, b-1, c-1) - getFunc(a,b-1,c);
        else
            return dp[a][b][c] = getFunc(a-1,b,c)+getFunc(a-1,b-1,c)+getFunc(a-1,b,c-1)-getFunc(a-1,b-1,c-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a == -1 && b == -1 && c == -1)
                break;
            System.out.println("w("+a+", "+b+", "+c+") = "+getFunc(a,b,c));
        }
    }
}
