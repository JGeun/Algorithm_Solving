package BOJ.Heewook.basic;

import java.util.Scanner;

public class Multiplication2588 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int first = sc.nextInt();
    int second = sc.nextInt();
    int ret = first * second;

    while (second > 0) {
      System.out.println((second % 10) * first);
      second /= 10;
    }
    System.out.println(ret);
  }
}