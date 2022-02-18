package BOJ.p4100;

import java.util.*;

public class BOJ4153 {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		
		int size = 3;
		int[] arr = new int[size];
		while(true) {
			for(int i=0; i<size; i++)
				arr[i] = sc.nextInt();
			
			if(arr[0] == 0 && arr[1] == 0 & arr[2] == 0)
				break;
			Arrays.sort(arr);
			if(Math.pow(arr[2],2) == Math.pow(arr[0],2) + Math.pow(arr[1],2))
				System.out.println("right");
			else
				System.out.println("wrong");
		}
	}
}
