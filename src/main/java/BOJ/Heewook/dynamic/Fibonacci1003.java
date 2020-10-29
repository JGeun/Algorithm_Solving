package BOJ.Heewook.dynamic;

import java.util.Scanner;

public class Fibonacci1003 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int testN = scanner.nextInt();
    for (int i = 0; i < testN; i++) {
      int n = scanner.nextInt();
      int a = 1, b = 0;
      while (n-- != 0) {
        int tmp = a + b;
        a = b;
        b = tmp;
      }
      System.out.println(a + " " + b);
    }
  }
}
