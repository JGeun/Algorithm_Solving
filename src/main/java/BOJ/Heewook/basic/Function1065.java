package BOJ.Heewook.basic;

import java.util.Scanner;

public class Function1065 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int count = 0;

    for (int i = 1; i <= n; i++)
      if (isHan(i))
        count++;

    System.out.println(count);
    sc.close();
  }

  private static boolean isHan(int number) {

    int now = number % 10;
    int next = 0;
    int diff = Integer.MAX_VALUE;
    while (number >= 10) {
      number /= 10;
      next = number % 10;
      if (diff != Integer.MAX_VALUE && diff != next - now)
        return false;
      diff = next - now;
      now = next;
    }
    return true;
  }
}