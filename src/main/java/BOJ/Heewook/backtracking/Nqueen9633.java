package BOJ.Heewook.backtracking;

import java.util.Scanner;

public class Nqueen9633 {

  final static int[][] d = { { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 } };

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[][] board = new int[n][n];
    System.out.println(find(board, n));
  }

  private static int find(int[][] board, int n) {
    if (n == 0)
      return 1;
    int count = 0;
    for (int x = 0; x < board.length; x++) {
      if (board[n - 1][x] == 0) {
        fill(x, n - 1, board, 1);
        count += find(board, n - 1);
        fill(x, n - 1, board, -1);
      }
    }
    return count;
  }

  private static void fill(int x, int y, int[][] board, int add) {
    board[y][x] += add;
    for (int i = 0; i < d.length; i++) {
      int nextX = x;
      int nextY = y;
      for (int n = 0; n < board.length; n++) {
        nextX += d[i][0];
        nextY += d[i][1];
        if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board.length)
          break;
        board[nextY][nextX] += add;
      }
    }
  }

}
