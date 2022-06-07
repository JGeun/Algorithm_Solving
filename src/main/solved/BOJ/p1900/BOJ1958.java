import java.io.*;
import java.util.*;

public class BOJ1958 {
    private static String[] line = new String[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<3; i++) line[i] = br.readLine();

        System.out.println(getLCS(line[0], line[1], line[2]));
    }

    private static int getLCS(String s1, String s2, String s3) {

        int[][][] dp = new int[s1.length() + 1][s2.length() + 1][s3.length() +  1];

        for(int i=1; i<=s1.length(); i++) {
            char ch1 = s1.charAt(i-1);
            for(int j=1; j<=s2.length(); j++) {
                char ch2 = s2.charAt(j-1);
                for(int k=1; k<=s3.length(); k++) {
                    char ch3 = s3.charAt(k-1);

                    if(ch1 == ch2 && ch2 == ch3) {
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()][s3.length()];
    }
}