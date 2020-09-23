package BOJ.Heewook.backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Operator14888 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++)
      numbers[i] = scanner.nextInt();
    ArrayList<Character> operators = new ArrayList<>();
    for (int order = 0; order < 4; order++) {
      int operatorN = scanner.nextInt();
      for (int i = 0; i < operatorN; i++)
        switch (order) {
          case 0:
            operators.add('+');
            break;
          case 1:
            operators.add('-');
            break;
          case 2:
            operators.add('*');
            break;
          case 3:
            operators.add('/');
        }
    }
    for (char c : operators)
      System.out.println(c);
    scanner.close();
  }

}
