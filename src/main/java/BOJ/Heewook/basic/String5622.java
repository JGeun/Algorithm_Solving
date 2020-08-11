package BOJ.Heewook.basic;

import java.util.Scanner;

public class String5622 {

  final static int[] strings = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String word = scanner.nextLine();
    int ret = 0;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      for (int number = 0; number < strings.length; number++)
        if (strings[number].indexOf(c) != -1)
          ret += number + 1;
    }
    System.out.println(ret);
    scanner.close();
  }
}