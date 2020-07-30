package BOJ.Heewook.basic;

import java.util.Scanner;

public class While1110 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int target = sc.nextInt();
    int numb = target;
    int count = 0;
    do {
      numb = (numb % 10 * 10) + (numb / 10 + numb % 10) % 10;
      count++;
    } while (numb != target);
    System.out.println(count);
    sc.close();
  }

}
