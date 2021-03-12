package BOJ.Heewook.basic;

import java.util.Arrays;

public class Function15596 {

  long sum(int[] a) {
    return Arrays.stream(a).mapToLong(n -> Integer.toUnsignedLong(n)).sum();
  }
  long sum2(int[] a) {
    long sum = 0;
    for (int i : a)
      sum += i;
    return sum;
  }
}