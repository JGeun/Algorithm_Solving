package BOJ.Heewook.mathBasic;

import java.util.Scanner;

public class Prime4948 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int num;
    int[] che = makeChe(123456 * 2);
    while ((num = scanner.nextInt()) != 0)
      System.out.println(countPrime(num, 2 * num, che));
  }

  private static int countPrime(final int num, final int num2, final int[] che) {
    int count = 0;
    for (int i = num + 1; i <= num2; i++)
      if (che[i] == 0)
        count++;
    return count;
  }

  private static int[] makeChe(int max) {

    int[] che = new int[max + 1];
    che[1] = 1;
    for (int i = 2; i * i <= max; i++) {
      if (che[i] == 1)
        continue;
      for (int j = i + i; j <= max; j += i)
        che[j] = 1;
    }
    return che;
  }

}