package BOJ.Heewook.backtracking;

import java.util.Scanner;

public class Sequence15650 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    recursive(n, m, 0, "");
  }

  private static void recursive(int n, int m, int referer, String s) {
    if (m == 0) {
      System.out.println(s);
      return;
    }
    for (int i = referer + 1; i <= n; i++)
      recursive(n, m - 1, i, s + i + " ");
  }
}
