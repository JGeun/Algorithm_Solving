
package BOJ.Heewook.sort;

import java.util.*;

public class Sort11650 {

  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] list = new int[n][2];
    for (int i = 0; i < n; i++){
      list[i][0] = sc.nextInt();
      list[i][1] = sc.nextInt();
    }
    
    Arrays.sort(list, (p1, p2) -> {
      if (p1[0] == p2[0])
        return p1[1] - p2[1];
      else
        return p1[0] - p2[0];
    });
    
    for (int i = 0; i < n; i++)
      System.out.println(list[i][0] + " " + list[i][1]);
  }

}
