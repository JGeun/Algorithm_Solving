package BOJ.Heewook.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Sort2750 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.valueOf(br.readLine());
    ArrayList<Integer> num = new ArrayList<>();
    for (int i = 0; i < n; i++)
      num.add(Integer.valueOf(br.readLine()));
    sort2(num);
    for (int i = 0; i < n; i++)
      bw.write(num.get(i) + "\n");
    bw.flush();
  }

  private static void sort1(final int[] num) {
    int tmp = 0;
    for (int i = 0; i < num.length; i++) {
      for (int j = i + 1; j < num.length; j++) {
        if (num[i] > num[j]) {
          tmp = num[i];
          num[i] = num[j];
          num[j] = tmp;
        }
      }
    }
  }

  private static void sort2(ArrayList<Integer> num) {
    Collections.sort(num);
  }

}
