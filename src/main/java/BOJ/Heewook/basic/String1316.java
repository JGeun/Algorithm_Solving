package BOJ.Heewook.basic;

import java.util.Scanner;

public class String1316 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int count = n;

    for (int i = 0; i < n; i++) {
      String word = scanner.next();
      boolean[] used = new boolean[26];
      for (int j = 1; j < word.length(); j++) {
        if (word.charAt(j - 1) != word.charAt(j)) {
          if (used[word.charAt(j) - 'a']) {
            count--;
            break;
          }
        }
        used[word.charAt(j - 1) - 'a'] = true;
      }
    }
    System.out.println(count);
    scanner.close();
  }
}