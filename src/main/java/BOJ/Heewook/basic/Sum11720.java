package BOJ.Heewook.basic;

import java.util.Scanner;

public class Sum11720 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    sc.nextInt();
    String numbers = sc.next();
    int sum = 0;
    for (int i = 0; i < numbers.length(); i++)
      sum += numbers.charAt(i) - '0';
    System.out.println(sum);
  }

}