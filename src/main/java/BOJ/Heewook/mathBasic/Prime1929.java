package BOJ.Heewook.mathBasic;

import java.util.Scanner;

public class Prime1929 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int n = scanner.nextInt();

    int[] che = new int[n + 1];
    che[1] = 1;
    for (int i = 1; i * i <= n; i++) {
      if (che[i] == 1)
        continue;
      for (int j = i + i; j <= n; j += i)
        che[j] = 1;
    }
    for (int i = m; i <= n; i++)
      if (che[i] == 0)
        System.out.println(i);

  }

}