package BOJ.Heewook.dynamic;

import java.util.Scanner;

public class Fibonacci2748 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println(recursive(n, new long[n + 1]));
    scanner.close();
  }

  private static long recursive(int n, long[] cache) {
    if (n <= 1)
      return n;
    if (cache[n] != 0)
      return cache[n];
    return cache[n] = recursive(n - 1, cache) + recursive(n - 2, cache);
  }

}
