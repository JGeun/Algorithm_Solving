package BOJ.Heewook.basic;

import java.util.Scanner;

public class MaxMin10818 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int numb = sc.nextInt();
      if (numb > max)
        max = numb;
      if (numb < min)
        min = numb;
    }
    System.out.printf("%d %d", min, max);
    sc.close();
  }
}