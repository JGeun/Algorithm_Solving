package BOJ.Heewook.recursive;

import java.util.Scanner;

public class Number1436 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int order = 0;
    int num = 0;
    while (n != order) {
      if (isCorrect(num))
        order++;
      num++;
    }
    System.out.println(num - 1);
  }

  private static boolean isCorrect(int num) {
    int ret = 0;
    int count = 0;
    int past = 0;
    while (num > 0) {
      int i = num % 10;
      if (i == 6 && (count == 0 || past == 6))
        count++;
      else {
        ret = Math.max(ret, count);
        count = 0;
      }
      num /= 10;
      past = i;
    }
    return ret >= 3 || count >= 3;
  }
}
