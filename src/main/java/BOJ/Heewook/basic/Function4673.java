package BOJ.Heewook.basic;

public class Function4673 {
  public static void main(String[] args) {
    int[] arr = new int[10036];
    for (int i = 1; i <= 10000; i++) {
      arr[d(i)] = 1;
      if (arr[i] != 1)
        System.out.println(i);
    }
  }
  private static int d(int n) {
    return n + ((n / 1000) % 10) + ((n / 100) % 10) + ((n / 10) % 10) + (n % 10);
  }
}
