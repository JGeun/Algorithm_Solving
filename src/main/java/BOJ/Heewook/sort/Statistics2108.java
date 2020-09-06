package BOJ.Heewook.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Statistics2108 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    double sum = 0;
    int[] list = new int[n];
    int[] count = new int[8001];
    int maxCount = 0;

    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      sum += num;
      list[i] = num;
      num += 4000;
      count[num]++;
      if (count[num] > maxCount)
        maxCount = count[num];
    }

    Arrays.sort(list);
    boolean twice = false;
    int maxCountNum = 0;

    for (int i = 0; i < count.length; i++) {
      if (count[i] == maxCount) {
        maxCountNum = i - 4000;
        if (twice)
          break;
        twice = true;
      }
    }

    System.out.println(Math.round(sum / n));
    System.out.println(list[n / 2]);
    System.out.println(maxCountNum);
    System.out.println(list[list.length - 1] - list[0]);
  }

}