package BOJ.Heewook.mathBasic;

import java.util.Scanner;

public class Calculate10250 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int c = sc.nextInt();
    while(c-- > 0){
      int h = sc.nextInt(), w = sc.nextInt(), n = sc.nextInt() - 1;
      System.out.println((n % h + 1) * 100 + (n / h + 1));
    }
  }

}