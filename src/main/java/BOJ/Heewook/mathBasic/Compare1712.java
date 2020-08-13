package BOJ.Heewook.mathBasic;

import java.util.Scanner;

public class Compare1712 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    long staticCost = scanner.nextInt();
    long cost = scanner.nextInt();
    long price = scanner.nextInt();
    if (price <= cost)
      System.out.println(-1);
    else
      System.out.println(staticCost / (price - cost) + 1);
    scanner.close();
  }
}