package BOJ.Heewook.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ForIf10871 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      int value = Integer.parseInt(st.nextToken());
      bw.write(value < x ? value + " " : "");
    }
    bw.flush();
    bw.close();
  }

}