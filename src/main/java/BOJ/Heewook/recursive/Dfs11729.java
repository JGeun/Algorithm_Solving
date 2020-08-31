package BOJ.Heewook.recursive;

import java.util.Scanner;

public class Dfs11729 {

  static int count = 0;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    recursive(n, 1, 2, 3);
    System.out.print(count + "\n" + sb.toString());
  }

  private static void recursive(int n, int from, int by, int to) {
    count++;
    if (n == 1)
      sb.append(from + " " + to + "\n");
    else {
      recursive(n - 1, from, to, by);
      sb.append(from + " " + to + "\n");
      recursive(n - 1, by, from, to);
    }
  }
}
