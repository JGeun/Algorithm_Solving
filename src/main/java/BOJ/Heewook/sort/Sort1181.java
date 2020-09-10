package BOJ.Heewook.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Sort1181 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Set<String> l = new TreeSet<>((s1, s2) -> {
      if (s1.length() != s2.length())
        return s1.length() - s2.length();
      else
        return s1.compareTo(s2);
    });
    for (int i = 0; i < n; i++)
      l.add(sc.next());
    for (String s : l)
      System.out.println(s);
  }
}
