package BOJ.Heewook.recursive;

import java.util.Scanner;

public class Fibonacci10870 {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println("recursive " + recursive(n));
    System.out.println("tailRecursive " + tailRecursive(n, 1, 0));
    System.out.println("loop " + loop(n));
  }

  private static int tailRecursive(int n, int pre, int prepre) {
    if (n < 2)
      return n * pre;
    return tailRecursive(n - 1, pre + prepre, pre);
  }

  private static int recursive(int n) {
    if (n == 0 || n == 1)
      return n;
    return recursive(n - 1) + recursive(n - 2);
  }

  private static int loop(int n) {

    int prepre = 0;
    int pre = 1;
    int current = 1;
    for (int i = 2; i <= n; i++) {
      current = pre + prepre;
      prepre = pre;
      pre = current;
    }
    return current;
  }

}