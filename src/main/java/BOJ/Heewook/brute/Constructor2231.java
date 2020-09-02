package BOJ.Heewook.brute;

import java.util.Scanner;

public class Constructor2231 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int ret = 0;
    for (int i = 0; i < n; i++) {
      if (isConstructor(i, n)) {
        ret = i;
        break;
      }
    }
    System.out.println(ret);
  }

  private static boolean isConstructor(int i, int n) {
    int num = i;
    while (i > 0) {
      num += i % 10;
      i /= 10;
    }
    return num == n;
  }

}