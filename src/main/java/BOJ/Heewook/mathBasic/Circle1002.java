package BOJ.Heewook.mathBasic;
import java.util.Scanner;

public class Circle1002 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int caseN = scanner.nextInt();
    for (int i = 0; i < caseN; i++) {
      int x1 = scanner.nextInt();
      int y1 = scanner.nextInt();
      int r1 = scanner.nextInt();
      int x2 = scanner.nextInt();
      int y2 = scanner.nextInt();
      int r2 = scanner.nextInt();
      int diff = Math.abs(r1 - r2);
      int sum = r1 + r2;
      double distance = Math.sqrt((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));

      if (x1 == x2 && y1 == y2 && r1 == r2)
        System.out.println(-1);
      else if (sum == distance || diff == distance)
        System.out.println(1);
      else if (diff < distance && distance < sum)
        System.out.println(2);
      else
        System.out.println(0);
    }
  }

}