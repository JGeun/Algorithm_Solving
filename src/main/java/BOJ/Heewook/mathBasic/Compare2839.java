package BOJ.Heewook.mathBasic;

import java.util.Scanner;

public class Compare2839 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int count = 0;
    while (n % 5 != 0 && n > 0) {
      n -= 3;
      count++;
    }
    System.out.println(n >= 0 ? count + n / 5 : -1);
    scanner.close();
  }
}