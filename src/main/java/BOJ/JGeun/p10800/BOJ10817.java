package BOJ.JGeun.p10800;

import java.util.*;

public class BOJ10817 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[3];
        for(int i=0; i<3; i++)
        	arr[i] = sc.nextInt();
        Arrays.sort(arr);
        System.out.println(arr[1]);
    }
}
