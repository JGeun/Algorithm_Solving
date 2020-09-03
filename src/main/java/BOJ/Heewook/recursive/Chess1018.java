package BOJ.Heewook.recursive;

import java.util.Scanner;

public class Chess1018 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int y = scanner.nextInt();
    int x = scanner.nextInt();
    char[][] board = new char[y][x];
    for (int i = 0; i < y; i++)
      board[i] = scanner.next().toCharArray();

    int ret = 64;
    for (int i = 0; i <= y - 8; i++) {
      for (int j = 0; j <= x - 8; j++) {
        int count = count(board, j, i);
        ret = Math.min(ret, Math.min(count, 64 - count));
      }
    }
    System.out.println(ret);
  }

  private static int count(final char[][] board, int x, int y) {
    int count = 0;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        char c = board[y + i][x + j];
        if ((i + j) % 2 == 0) {
          if (c != 'B')
            count++;
        } else if (c != 'W')
          count++;
      }
    }
    return count;
  }
}
