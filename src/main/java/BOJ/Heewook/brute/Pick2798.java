package BOJ.Heewook.brute;

import java.util.ArrayList;
import java.util.Scanner;

public class Pick2798 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[] cards = new int[n];
    for (int i = 0; i < n; i++)
      cards[i] = scanner.nextInt();
    System.out.println(recursive(m, cards, new ArrayList<Integer>()));
  }

  private static int recursive(final int limit, final int[] cards, ArrayList<Integer> picked) {
    if (picked.size() == 3)
      return calculate(limit, picked);
    int ret = 0;
    for (int i = 0; i < cards.length; i++) {
      if (!picked.contains(cards[i])) {
        picked.add(cards[i]);
        ret = Math.max(ret, recursive(limit, cards, picked));
        picked.remove(picked.size() - 1);
      }
    }
    return ret;
  }

  private static int calculate(int limit, ArrayList<Integer> list) {
    int sum = 0;
    for (int i = 0; i < list.size(); i++)
      sum += list.get(i);
    return sum <= limit ? sum : -1;
  }
}