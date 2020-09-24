package BOJ.Heewook.backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Operator14888 {

  static int max = Integer.MIN_VALUE;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++)
      numbers[i] = scanner.nextInt();
    ArrayList<Character> operators = new ArrayList<>();
    for (int order = 0; order < 4; order++) {
      int operatorN = scanner.nextInt();
      for (int i = 0; i < operatorN; i++)
        switch (order) {
          case 0:
            operators.add('+');
            break;
          case 1:
            operators.add('-');
            break;
          case 2:
            operators.add('*');
            break;
          case 3:
            operators.add('/');
        }
    }
    find(0, numbers[0], numbers, operators, new boolean[n - 1]);
    System.out.println(max);
    System.out.println(min);
    scanner.close();
  }

  private static void find(int n, int now, final int[] numbers, ArrayList<Character> operators, boolean[] used) {
    if (n == numbers.length - 1) {
      max = Math.max(max, now);
      min = Math.min(min, now);
      return;
    }
    for (int i = 0; i < operators.size(); i++) {
      if (used[i])
        continue;
      used[i] = true;
      switch (operators.get(i)) {
        case '+':
          find(n + 1, now + numbers[n + 1], numbers, operators, used);
          break;
        case '-':
          find(n + 1, now - numbers[n + 1], numbers, operators, used);
          break;
        case '*':
          find(n + 1, now * numbers[n + 1], numbers, operators, used);
          break;
        case '/':
          find(n + 1, now / numbers[n + 1], numbers, operators, used);
      }
      used[i] = false;
    }
  }

}
