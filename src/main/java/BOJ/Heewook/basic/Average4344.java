package BOJ.Heewook.basic;

import java.util.Scanner;

public class Average4344 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();
    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      int[] scores = new int[n];
      int sum = 0;
      int average = 0;
      int count = 0;
      for (int j = 0; j < n; j++) {
        scores[j] = sc.nextInt();
        sum += scores[j];
      }
      average = sum / n;
      for (int j = 0; j < n; j++)
        if (scores[j] > average)
          count++;
      System.out.printf("%.3f%%%n", (double) count / n * 100);
    }
    sc.close();
  }
}