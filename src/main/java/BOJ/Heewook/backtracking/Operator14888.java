package BOJ.Heewook.backtracking;

import java.util.Scanner;

public class Operator14888 {

  static int max = Integer.MIN_VALUE;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] numbers = new int[n];
    int[] operators = new int[4];
    for (int i = 0; i < n; i++)
      numbers[i] = scanner.nextInt();
    for (int i = 0; i < 4; i++)
      operators[i] = scanner.nextInt();
    find(0, numbers[0], numbers, operators);
    System.out.println(max);
    System.out.println(min);
    scanner.close();
  }

  private static void find(int n, int now, final int[] numbers, int[] operators) {
    if (n == numbers.length - 1) {
      max = Math.max(max, now);
      min = Math.min(min, now);
      return;
    }
    for (int i = 0; i < 4; i++) {
      if (operators[i] > 0) {
        operators[i]--;
        switch (i) {
          case 0:
            find(n + 1, now + numbers[n + 1], numbers, operators);
            break;
          case 1:
            find(n + 1, now - numbers[n + 1], numbers, operators);
            break;
          case 2:
            find(n + 1, now * numbers[n + 1], numbers, operators);
            break;
          case 3:
            find(n + 1, now / numbers[n + 1], numbers, operators);
        }
        operators[i]++;
      }
    }
  }

}
