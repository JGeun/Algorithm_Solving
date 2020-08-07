package BOJ.Heewook.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Word1152 {

  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokens = new StringTokenizer(reader.readLine());
    System.out.println(tokens.countTokens());
  }
  
}