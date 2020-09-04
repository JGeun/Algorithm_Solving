package BOJ.Heewook.sort;

import java.util.Scanner;

public class Sort2750 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] num = new int[n];
    for (int i = 0; i < n; i++)
      num[i] = scanner.nextInt();
    int tmp = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (num[i] > num[j]) {
          tmp = num[i];
          num[i] = num[j];
          num[j] = tmp;
        }
      }
    }
    for (int i = 0; i < n; i++)
      System.out.println(num[i]);
  }

}
