package BOJ.Heewook.backtracking;

import java.util.Scanner;

public class Nqueen9633 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    boolean[][] board = new boolean[n][n];
    find(board, 0, 0, n);
  }

  private static int find(boolean[][] board, int x, int y, int n) {
    if (n == 0)
      return 1;
    int count = 0;
    for (int dy = 0; dy < n; dy++) {
      for (int dx = 0; dx < n; dx++) {
        if (board[dy][dx]) {
          fill(dx, dy, board);
          count += find(board, dx, dy, n - 1);
          unfill(dx, dy, board);
        }
      }
    }
    return count;
  }

  private static void fill(int x, int y, boolean[][] board) {
  }

  private static void unfill(int x, int y, boolean[][] board) {
  }

}
