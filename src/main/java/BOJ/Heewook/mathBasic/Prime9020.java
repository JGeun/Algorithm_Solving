package BOJ.Heewook.mathBasic;

import java.util.Scanner;

public class Prime9020 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    final int[] che = makeChe(10000);
    int caseN = scanner.nextInt();
    int left, right;
    for (int i = 0; i < caseN; i++) {
      int num = scanner.nextInt();
      left = right = num / 2;
      while (che[left] != 0 || che[right] != 0) {
        left--;
        right++;
      }
      System.out.println(left + " " + right);
    }
  }

  private static int[] makeChe(int max) {
    int[] che = new int[max + 1];
    che[1] = 1;
    for (int i = 2; i * i <= max; i++) {
      if (che[i] == 1)
        continue;
      for (int j = i * i; j <= max; j += i)
        che[j] = 1;
    }
    return che;
  }
}