package BOJ.Heewook.backtracking;

import java.util.Scanner;

public class Nqueen9633 {

  static int n;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    int[] arr = new int[n];
    System.out.println(find(0, arr));
  }

  private static int find(int y, int[] arr) {
    if (y == n)
      return 1;
    int count = 0;
    for (int x = 0; x < n; x++) {
      arr[y] = x;
      if (!isCorrect(x, y, arr))
        continue;
      count += find(y + 1, arr);
    }
    return count;
  }

  private static boolean isCorrect(int x, int y, int[] arr) {
    for (int pastY = 0; pastY < y; pastY++) {
      int pastX = arr[pastY];
      if (pastX == x || Math.abs(x - pastX) == y - pastY)
        return false;
    }
    return true;
  }
}
