package BOJ.Heewook.mathBasic;
import java.util.Scanner;
public class Order1193 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int count = 1;
    while (n > 0) {
      n -= count;
      count++;
    }
    n--;
    System.out.println(count % 2 != 0 ? (count + n) + "/" + -n : -n + "/" + (count + n));
  }
}