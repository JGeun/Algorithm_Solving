package BOJ.Heewook.basic;

import java.util.Scanner;

public class IfCase2884 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int ret = sc.nextInt() * 60 + sc.nextInt() - 45;
    int retHour = ret < 0 ? 23 : ret / 60;
    int retMinute = ret < 0 ? ret + 60 : ret % 60;
    System.out.println(retHour + " " + retMinute);
  }

}