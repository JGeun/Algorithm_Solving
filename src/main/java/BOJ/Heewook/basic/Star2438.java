package BOJ.Heewook.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star2438 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    String ret = "";
    for (int i = 0; i < n; i++) {
      ret += "*";
      bw.write(ret + "\n");
    }
    bw.flush();
    bw.close();
  }
}