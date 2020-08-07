package BOJ.Heewook.basic;

import java.util.Scanner;

public class Alpabet2941 {

  private final static String[] alpabet = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String word = scanner.nextLine();
    System.out.println(recursive(word, 0));
    scanner.close();
  }

  private static int recursive(final String word, int index) {
    if (index == word.length())
      return 0;
    for (int i = 0; i < alpabet.length; i++)
      if (word.startsWith(alpabet[i], index))
        return 1 + recursive(word, index + alpabet[i].length());
    return 1 + recursive(word, index + 1);
  }
}