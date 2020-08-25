package BOJ.Heewook.basic;
import java.util.Arrays;
import java.util.Scanner;
public class Pythagorean4153 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int[] a = new int[3];
    while (true) {
      for (int i = 0; i < 3; i++)
        a[i] = sc.nextInt();
      if (a[0] == 0)
        break;
      Arrays.sort(a);
      if (a[2] * a[2] == a[0] * a[0] + a[1] * a[1])
        System.out.println("right");
      else
        System.out.println("wrong");
    }
  }

}