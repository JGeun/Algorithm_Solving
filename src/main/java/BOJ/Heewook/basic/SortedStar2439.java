package BOJ.Heewook.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SortedStar2439 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String ret = "";
    for (int i = 0; i < n; i++) {
      ret += "*";
      System.out.printf("%" + n + "s\n", ret);
    }
  }
}