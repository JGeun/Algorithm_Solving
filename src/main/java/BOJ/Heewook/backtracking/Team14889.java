package BOJ.Heewook.backtracking;

import java.util.Scanner;

public class Team14889 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[][] info = new int[n][n];
    boolean[] used = new boolean[n];

    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        info[i][j] = scanner.nextInt();

    System.out.println(recursive(n / 2, 0, info, used));
  }

  private static int recursive(int n, int index, final int[][] info, boolean[] used) {

    if (n == 0)
      return calc(info, used);

    int ret = Integer.MAX_VALUE;
    for (int i = index; i < info.length; i++) {
      if (used[i])
        continue;
      used[i] = true;
      ret = Math.min(ret, recursive(n - 1, i + 1, info, used));
      used[i] = false;
    }
    return ret;
  }

  private static int calc(final int[][] info, boolean[] used) {
    int sum = 0;
    int sum2 = 0;

    for (int i = 0; i < used.length - 1; i++)
      for (int j = i + 1; j < used.length; j++)
        if (used[j] && used[i])
          sum += info[i][j] + info[j][i];
        else if (!used[j] && !used[i])
          sum2 += info[i][j] + info[j][i];

    return Math.abs(sum - sum2);
  }

}
