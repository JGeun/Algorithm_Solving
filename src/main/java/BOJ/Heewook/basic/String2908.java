package BOJ.Heewook.basic;

import java.util.Scanner;
import java.util.StringTokenizer;

public class String2908 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    StringTokenizer token = new StringTokenizer(scanner.nextLine());
    int max = -1;

    while (token.hasMoreTokens()) {
      String[] next = token.nextToken().split("");
      String reversed = "";
      for (int i = next.length - 1; i >= 0; i--)
        reversed += next[i];
      int reversedInt = Integer.parseInt(reversed);
      if (reversedInt > max)
        max = reversedInt;

    }
    System.out.println(max);
    sc.close();
  }
}