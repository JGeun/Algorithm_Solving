package BOJ.Heewook.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Sort1181 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    Set<String> list = new TreeSet<>((s1, s2) -> {
      if (s1.length() != s2.length())
        return s1.length() - s2.length();
      else
        return s1.compareTo(s2);
    });
    for (int i = 0; i < n; i++)
      list.add(scanner.next());
    for (String s : list)
      System.out.println(s);
  }
}
