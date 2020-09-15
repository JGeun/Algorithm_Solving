package BOJ.Heewook.backtracking;

import java.util.Scanner;

public class Sequence15649 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    recursive(n, m, new boolean[n + 1], "");
    scanner.close();
  }

  private static void recursive(final int n, int m, boolean[] used, String s) {

    if (m == 0) {
      System.out.println(s);
      return;
    }
    for (int i = 1; i <= n; i++) {
      if (used[i])
        continue;
      used[i] = true;
      recursive(n, m - 1, used, s + i + " ");
      used[i] = false;
    }
  }

}
