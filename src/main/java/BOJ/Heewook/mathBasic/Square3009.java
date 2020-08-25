package BOJ.Heewook.mathBasic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Square3009 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Map<Integer, Integer> xMap = new HashMap<>();
    Map<Integer, Integer> yMap = new HashMap<>();
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < 3; i++) {
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      xMap.put(x, xMap.getOrDefault(x, 0) + 1);
      yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }
    for (Integer key : xMap.keySet())
      if (xMap.get(key) % 2 != 0)
        builder.append(key + " ");
    for (Integer key : yMap.keySet())
      if (yMap.get(key) % 2 != 0)
        builder.append(key);
    System.out.println(builder);
  }

}