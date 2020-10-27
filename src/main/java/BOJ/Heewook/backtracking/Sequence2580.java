package BOJ.Heewook.backtracking;

import java.util.Scanner;

class Pair {

  private int x;
  private int y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}

public class Sequence2580 {

  static int[][] board;
  static int n = 9;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    board = new int[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        board[i][j] = scanner.nextInt();
    recursive();
  }

  private static void recursive() {

    Pair unfilled = findUnfilled();
    int x = unfilled.getX();
    int y = unfilled.getY();
    if (x == -1) {
      print();
      System.exit(0);
    }
    for (int num = 1; num <= n; num++)
      if (isPossible(num, x, y)) {
        board[y][x] = num;
        recursive();
        board[y][x] = 0;
      }
  }

  private static boolean isPossible(int num, int x, int y) {
    for (int i = 0; i < 9; i++)
      if (board[y][i] == num || board[i][x] == num)
        return false;
    int areaX = (x / 3) * 3;
    int areaY = (y / 3) * 3;
    for (int i = areaY; i < areaY + 3; i++)
      for (int j = areaX; j < areaX + 3; j++)
        if (board[i][j] == num)
          return false;
    return true;
  }

  private static Pair findUnfilled() {
    for (int y = 0; y < n; y++)
      for (int x = 0; x < n; x++)
        if (board[y][x] == 0)
          return new Pair(x, y);
    return new Pair(-1, -1);
  }

  private static void print() {
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++)
        System.out.print(board[y][x] + " ");
      System.out.println();
    }
  }

}
