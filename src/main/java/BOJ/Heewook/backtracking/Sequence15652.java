package BOJ.Heewook.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sequence15652 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    recursive(n, m, 1, "");
    bw.flush();
    br.close();
    bw.close();
  }

  private static void recursive(int n, int m, int referer, String s) throws IOException {
    if (m == 0) {
      bw.write(s + "\n");
      return;
    }
    for (int i = referer; i <= n; i++)
      recursive(n, m - 1, i, s + i + " ");
  }
}
