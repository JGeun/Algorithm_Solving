package BOJ.Heewook.kakao.spring2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class CourseMenu {

  public static void main(String[] args) {
    String[] ret = new CourseMenu().solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" },
        new int[] { 2, 3, 4 });
    for (String s : ret)
      System.out.println(s);
  }

  static String[] usedAlphabet;

  public String[] solution(String[] orders, int[] course) {

    ArrayList<String> ret = new ArrayList<>();
    HashSet<String> usedAlphabetSet = new HashSet<>();

    for (String order : orders)
      for (char c : order.toCharArray())
        usedAlphabetSet.add(String.valueOf(c));

    usedAlphabet = usedAlphabetSet.toArray(new String[usedAlphabetSet.size()]);

    for (int n : course) {
      HashMap<String, Integer> countMap = new HashMap<>();
      int maxCount = find(n, orders, "", -1, countMap);
      for (Map.Entry<String, Integer> e : countMap.entrySet())
        if (e.getValue() == maxCount)
          ret.add(e.getKey());
    }
    Collections.sort(ret);
    return ret.toArray(new String[ret.size()]);
  }

  private int find(int n, final String[] orders, String menu, int referer, HashMap<String, Integer> countMap) {
    if (n == 0)
      return calculate(orders, menu, countMap);
    int maxCount = 0;
    for (int i = referer + 1; i < usedAlphabet.length; i++)
      maxCount = Math.max(maxCount, find(n - 1, orders, menu + usedAlphabet[i], i, countMap));
    return maxCount;
  }

  private int calculate(final String[] orders, String menu, HashMap<String, Integer> countMap) {

    int count = 0;

    for (String order : orders) {
      if (order.length() < menu.length())
        continue;

      boolean haveMenu = true;
      for (char c : menu.toCharArray()) {
        if (order.indexOf(c) == -1) {
          haveMenu = false;
          break;
        }
      }
      if (haveMenu)
        count++;
    }
    if (count >= 2)
      countMap.put(menu, count);
    return count;
  }
}
