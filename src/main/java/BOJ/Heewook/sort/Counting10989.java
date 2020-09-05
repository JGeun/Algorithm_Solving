package BOJ.Heewook.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Counting10989 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.valueOf(br.readLine());
    int[] list = new int[10001];
    for (int i = 0; i < n; i++)
      list[Integer.valueOf(br.readLine())]++;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int num = 0; num < 10001; num++) {
      if (list[num] != 0) {
        for (int i = 0; i < list[num]; i++)
          bw.write(num + "\n");
      }
    }
    bw.flush();
  }
}
