package BOJ.Heewook.mathBasic;

import java.util.Scanner;

public class Compare2292 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt() - 1;
    int count = 1;
    while (n > 0) {
      n = n - (count * 6);
      count++;
    }
    System.out.println(count);
    scanner.close();
  }
}