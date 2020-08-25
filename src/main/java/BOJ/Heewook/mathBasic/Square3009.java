package BOJ.Heewook.mathBasic;

import java.util.Scanner;

public class Square3009 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int x1 = scanner.nextInt();
    int y1 = scanner.nextInt();
    int x2 = scanner.nextInt();
    int y2 = scanner.nextInt();
    int x3 = scanner.nextInt();
    int y3 = scanner.nextInt();
    System.out.println((x1 ^ x2 ^ x3) + " " + (y1 ^ y2 ^ y3));
    
  }

}