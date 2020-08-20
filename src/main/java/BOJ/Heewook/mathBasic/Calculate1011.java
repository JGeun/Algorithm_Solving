package BOJ.Heewook.mathBasic;

import java.util.Scanner;

public class Calculate1011 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    long caseN = sc.nextInt();

    for (int i = 0; i < caseN; i++) {
      int length = -sc.nextInt() + sc.nextInt();
      long count = 0;
      int gap = 0;
      while (length > count) {
        gap += 2;
        count += gap;
      }
      if (length > count - (gap / 2))
        System.out.println(gap);
      else
        System.out.println(gap - 1);
    }

  }

}