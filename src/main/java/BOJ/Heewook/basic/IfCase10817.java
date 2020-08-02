package BOJ.Heewook.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class IfCase10817 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int first = -1;
    int second = -1;
    while (st.hasMoreTokens()) {
      int numb = Integer.parseInt(st.nextToken());
      if (numb >= first) {
        second = first;
        first = numb;
      } else if(numb > second)
      second = numb;
    }
    bw.write(second + "");
    bw.flush();
    bw.close();
  }
}