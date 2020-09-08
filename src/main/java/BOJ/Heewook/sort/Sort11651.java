package BOJ.Heewook.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Sort11651 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] l = new int[n][2];

    for (int i = 0; i < n; i++) {
      l[i][0] = sc.nextInt();
      l[i][1] = sc.nextInt();
    }
    Arrays.sort(l, (p1, p2) -> {
      if (p1[1] == p2[1])
        return p1[0] - p2[0];
      else
        return p1[1] - p2[1];
    });
    for (int[] p : l)
      System.out.println(p[0] + " " + p[1]);
  }
}
