package BOJ.Heewook.basic;

import java.util.Scanner;

public class String5622 {

  final static int[] numbers = { 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10 };

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String word = scanner.nextLine();
    int ret = 0;
    for (int i = 0; i < word.length(); i++)
      ret += numbers[word.charAt(i) - 'A'];
    System.out.println(ret);
    scanner.close();
  }
}