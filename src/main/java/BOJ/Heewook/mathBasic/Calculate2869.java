package BOJ.Heewook.mathBasic;

import java.util.Scanner;

public class Calculate2869 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int day = sc.nextInt();
    int night = sc.nextInt();
    int height = sc.nextInt();
    System.out.println((height - night - 1) / (day - night) + 1);

  }

}