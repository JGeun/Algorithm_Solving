package BOJ.Heewook.dynamic;

import java.util.*;

public class Padovan9461 {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int testN = scanner.nextInt();
    long[] list = new long[100 + 1];
    list[0] = 0;
    list[1] = 1;
    list[2] = 1;
    for (int i = 3; i <= 100; i++)
      list[i] = list[i - 2] + list[i - 3];
    for (int j = 0; j < testN; j++){
      int n = scanner.nextInt();
      System.out.println(list[n]);
    }
  }
}
