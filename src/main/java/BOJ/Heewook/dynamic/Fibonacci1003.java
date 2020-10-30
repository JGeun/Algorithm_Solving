package BOJ.Heewook.dynamic;

import java.util.Scanner;

public class Fibonacci1003 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testN = scanner.nextInt();
    int[] dp = new int[41];
    dp[0] = 0;
    dp[1] = 1;
    for (int j = 2; j <= 40; j++)
      dp[j] = dp[j - 1] + dp[j - 2];
    for (int i = 0; i < testN; i++) {
      int n = scanner.nextInt();
      String ret;
      if (n == 0)
        ret = String.format("%d %d", 1, 0);
      else
        ret = String.format("%d %d", dp[n - 1], dp[n]);
      System.out.println(ret);
    }
  }
}
