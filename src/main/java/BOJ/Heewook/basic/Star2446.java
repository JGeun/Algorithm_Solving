package BOJ.Heewook.basic;

import java.util.Scanner;

public class Star2446 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++)
        System.out.print(" ");
      for (int j = 0; j < (2 * n - 1) - 2 * i; j++)
        System.out.print("*");
      System.out.println();
    }
    for (int i = n - 1; i >= 0; i--) {
      if (i == n - 1)
        continue;
      for (int j = 0; j < i; j++)
        System.out.print(" ");

      for (int j = 0; j < (2 * n - 1) - 2 * i; j++)
        System.out.print("*");
      System.out.println();
    }

  }

}