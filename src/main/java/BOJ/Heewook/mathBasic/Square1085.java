package BOJ.Heewook.mathBasic;

import java.util.Scanner;

public class Square1085 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    int w = scanner.nextInt();
    int h = scanner.nextInt();
    int xDiff = Math.min(w - x, x);
    int yDiff = Math.min(h - y, y);
    System.out.println(Math.min(xDiff, yDiff));

  }

}