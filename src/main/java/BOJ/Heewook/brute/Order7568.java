package BOJ.Heewook.brute;

import java.util.Scanner;

class People {

  private int weight;
  private int height;

  public People(int weight, int height) {
    this.weight = weight;
    this.height = height;
  }

  public boolean isSmaller(People another) {
    return this.weight < another.weight && this.height < another.height;
  }

}

public class Order7568 {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    People[] peoples = new People[n];
    for (int i = 0; i < n; i++)
      peoples[i] = new People(scanner.nextInt(), scanner.nextInt());
    for (int i = 0; i < n; i++) {
      int order = 1;
      for (int j = 0; j < n; j++)
        if (i != j && peoples[i].isSmaller(peoples[j]))
          order++;
      System.out.print(order + " ");
    }
  }
}