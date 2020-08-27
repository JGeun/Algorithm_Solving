package BOJ.Heewook.recursive;

import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println(recursive(n));
  }

  private static int recursive(int n) {
    if (n == 0 || n == 1)
      return n;
    return recursive(n - 1) + recursive(n - 2);
  }

}