package BOJ.Heewook.recursive;

import java.util.Arrays;
import java.util.Scanner;

public class Star2447 {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    char[][] board = new char[n][n];
    for (char[] b : board)
      Arrays.fill(b, ' ');
    recursive(board, 0, 0, n);
    for (char[] b : board)
      System.out.println(b);
    scanner.close();
  }

  private static void recursive(char[][] board, int x, int y, int n) {
    if (n == 1) {
      board[x][y] = '*';
      return;
    }
    n /= 3;
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        if (!(i == 1 && j == 1))
          recursive(board, x + (i * n), y + (j * n), n);
  }
}