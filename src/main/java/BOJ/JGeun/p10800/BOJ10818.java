package BOJ.JGeun.p10800;

import java.util.*;

public class BOJ10818 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++){
			array.add(sc.nextInt());
		}
		array.sort(null);
		System.out.println(array.get(0) +" " + array.get(N-1));
	}
}
