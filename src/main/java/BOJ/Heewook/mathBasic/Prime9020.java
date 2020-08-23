package BOJ.Heewook.mathBasic;

import java.util.ArrayList;
import java.util.Scanner;

class Couple {

  private int first;
  private int second;

  public int getFirst() {
    return this.first;
  }

  public int getSecond() {
    return this.second;
  }

  public void setFirst(int first) {
    this.first = first;
  }

  public void setSecond(int second) {
    this.second = second;
  }

}

public class Prime9020 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    final int[] che = makeChe(10000);
    int caseN = scanner.nextInt();
    for (int i = 0; i < caseN; i++) {
      ArrayList<Integer> primes = new ArrayList<>();
      int num = scanner.nextInt();
      for (int j = 2; j <= num; j++)
        if (che[j] == 0)
          primes.add(j);
      Couple ret = findCouple(num, primes);
      System.out.println(ret.getFirst() + " " + ret.getSecond());
    }

  }

  private static Couple findCouple(final int num, final ArrayList<Integer> primes) {
    int gap = Integer.MAX_VALUE;
    Couple ret = new Couple();

    for (int i = 0; i < primes.size(); i++) {
      for (int j = i; j < primes.size(); j++) {
        if (primes.get(i) + primes.get(j) == num) {
          if (gap > primes.get(j) - primes.get(i)) {
            gap = primes.get(j) - primes.get(i);
            ret.setFirst(primes.get(i));
            ret.setSecond(primes.get(j));
            break;
          }
        }
      }
      if (gap == 0)
        break;
    }
    return ret;
  }

  private static int[] makeChe(int max) {
    int[] che = new int[max + 1];
    che[1] = 1;
    for (int i = 2; i * i <= max; i++) {
      if (che[i] == 1)
        continue;
      for (int j = i + i; j <= max; j += i)
        che[j] = 1;
    }
    return che;
  }
}