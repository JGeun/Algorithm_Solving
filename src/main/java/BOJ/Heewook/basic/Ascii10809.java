package BOJ.Heewook.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ascii10809 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String c = reader.readLine();

    for (int i = 0; i < 26; i++)
      System.out.print(c.indexOf(i + 'a') + " ");

  }

}