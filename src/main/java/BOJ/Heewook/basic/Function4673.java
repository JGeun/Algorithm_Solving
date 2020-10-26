package BOJ.Heewook.basic;

public class Function4673 {

  public static void main(String[] args) {

    for (int i = 1; i <= 10000; i++)
      if (isSelf(i))
        System.out.println(i);
  }

  private static boolean isSelf(int num) {

    for (int con = 1; con < num; con++) {
      int sum = con;
      int temp = con;
      while (temp > 0) {
        sum += temp % 10;
        temp /= 10;
      }
      if (sum == num)
        return false;
    }
    return true;
  }

}
