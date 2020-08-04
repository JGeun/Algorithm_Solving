package BOJ.Heewook.basic;

import java.util.Scanner;

public class MaxChar1157 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String word = sc.nextLine().toUpperCase();
    int max = -1;
    char ret = '?';
    int[] list = new int[26];
    for (int i = 0; i < word.length(); i++) {
      int count = list[word.charAt(i) - 'A']++;
      if (count > max) {
        max = count;
        ret = word.charAt(i);
      } else if (count == max)
        ret = '?';
    }
    System.out.println(ret);
    sc.close();
  }
}