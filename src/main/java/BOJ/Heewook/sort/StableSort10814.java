package BOJ.Heewook.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//Arrays.sort는 stable 한 sort이다.
public class StableSort10814 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[][] p = new String[n][2];
    for (int i = 0; i < n; i++) {
      p[i][0] = sc.next();
      p[i][1] = sc.next();
    }
    Arrays.sort(p, Comparator.comparingInt(s -> Integer.parseInt(s[0])));
    for (String[] o : p)
      System.out.println(o[0] + " " + o[1]);
    sc.close();
  }
}
