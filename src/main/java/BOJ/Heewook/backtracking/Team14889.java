package BOJ.Heewook.backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Team14889 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[][] info = new int[n][n];
    ArrayList<Integer> used = new ArrayList<>();

    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        info[i][j] = scanner.nextInt();

    recursive(n, info, used);
  }

  private static int recursive(int n, final int[][] info, ArrayList<Integer> used) {

    if (n == 0)
      return calc(info, used);

    int ret = Integer.MAX_VALUE;
    for (int i = 0; i < info.length; i++) {
      if (used.contains(i))
        continue;
      used.add(i);
      ret = Math.min(ret, recursive(n - 1, info, used));
      used.remove(used.size() - 1);
    }
    return ret;
  }

  private static int calc(final int[][] info, ArrayList<Integer> used) {

    for (int i = 0; i < used.size(); i++) {
      if (i == used.size() / 2)
        System.out.println("==========");
      System.out.println(used.get(i));
    }
    int a = 0;
    int b = 0;
    for (int i = 0; i < used.size(); i++) {
      if (i >= used.size() / 2)
        a += used.get(i);
      else
        b += used.get(i);
    }
    System.out.println("=============================================" + Math.abs(a - b));
    return Math.abs(a - b);
  }

}
