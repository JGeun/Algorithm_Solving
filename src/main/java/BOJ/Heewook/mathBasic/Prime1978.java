package BOJ.Heewook.mathBasic;

import java.util.ArrayList;
import java.util.Scanner;

public class Prime1978 {

  static int[] che;
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    ArrayList<Integer> numbers = new ArrayList<>();
    int count = 0;
    int max = 0;
    while (n-- > 0) {
      int number = scanner.nextInt();
      max = Math.max(max, number);
      numbers.add(number);
    }
    che = makeChe(numbers, max);
    for (int j = 0; j < numbers.size(); j++)
      if (che[numbers.get(j)] == 0)
        count++;
    System.out.println(count);
    }

  private static  int[] makeChe(ArrayList<Integer> numbers, int max) {
    int[] che = new int[max + 1];
    che[1] = 1;
    for (int i = 2; i * i <= max; i++) {
      if (che[i] == 1) continue;
      for (int j = i + i; j <= max; j += i) 
      che[j] = 1;
    }
    return che;
  }
  
}