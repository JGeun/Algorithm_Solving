package BOJ.Heewook.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sequence15651 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    recursive(n, m, "");
    bw.flush();
    br.close();
    bw.close();
  }

  private static void recursive(int n, int m, String s) throws IOException {
    if (m == 0) {
      bw.write(s + "\n");
      return;
    }
    for (int i = 1; i <= n; i++)
      recursive(n, m - 1, s + i + " ");
  }
}
