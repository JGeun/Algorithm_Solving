package BOJ.Heewook.brute;

import java.util.Scanner;

public class Pick2798 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[] cards = new int[n];
    for (int i = 0; i < n; i++)
      cards[i] = scanner.nextInt();
    System.out.println(recursive(m, cards, -1, 0, 0));
    scanner.close();
  }

  private static int recursive(final int limit, final int[] cards, int past, int sum, int count) {
    if (count == 3)
      return sum <= limit ? sum : -1;
    int ret = 0;
    for (int i = past + 1; i < cards.length; i++)
      ret = Math.max(ret, recursive(limit, cards, i, sum + cards[i], count + 1));
    return ret;
  }

}