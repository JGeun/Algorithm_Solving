package BOJ.Heewook.recursive;

import java.util.Scanner;

public class Factorial10872 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println(recursive(n));
  }

  private static int recursive(int n) {
    if (n == 0)
      return 1;
    return n * recursive(n - 1);
  }

}