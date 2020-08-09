package BOJ.Heewook.basic;

import java.io.IOException;
import java.util.Scanner;

public class String2675 {

  public static void main(String[] args) throws IOException {

    Scanner scanner = new Scanner(System.in);
    int caseN = scanner.nextInt();

    for (int i = 0; i < caseN; i++) {
      int n = scanner.nextInt();
      String text = scanner.next();
      for (int j = 0; j < text.length(); j++)
        for (int c = 0; c < n; c++)
          System.out.print(text.charAt(j));
      System.out.println();
    }
    scanner.close();
  }

}