package BOJ.Heewook.mathBasic;

import java.util.Scanner;

public class Calculate2775 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int c = sc.nextInt();
    for (int i = 0; i < c; i++)
      System.out.println(find(sc.nextInt(), sc.nextInt()));
  }

  private static int find(int k, int n) {
    if (k == 0)
      return n;
    if (n == 0)
      return 0;
    return find(k, n - 1) + find(k - 1, n);
  }
}