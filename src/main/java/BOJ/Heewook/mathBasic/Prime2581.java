package BOJ.Heewook.mathBasic;

import java.util.Scanner;

class Pair {

  private int sum;
  private int min;

  public Pair() {
    this.sum = 0;
    this.min = Integer.MAX_VALUE;
  }

  public int getSum() {
    return this.sum;
  }
  public int getMin() {
    return this.min;
  }
  public void add(int num) {
    this.sum += num;
  }
  public void setMin(int num) {
    this.min = Math.min(num, min);
  }
}

public class Prime2581 {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    Pair p = new Pair();

    int[] che = makeChe(n);

    for (int i = m; i <= n; i++) {
      if (che[i] == 0) {
        p.add(i);
        p.setMin(i);
      }
    }
    if (p.getSum() == 0) 
      System.out.println(-1);
    else
      System.out.println(p.getSum() + "\n" + p.getMin());

  }

  private static int[] makeChe(int n) {
    int[] che = new int[n + 1];
    che[1] = 1;
    for (int i = 2; i <= n; i++) {
      if (che[i] == 1) continue;
      for (int j = i + i; j <= n; j += i)
        che[j] = 1;
    }
    return che;
  }

}