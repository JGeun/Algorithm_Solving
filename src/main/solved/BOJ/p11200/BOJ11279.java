package BOJ.p11200;

import java.util.*;

public class BOJ11279 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			pq.add(num);
			if(num == 0)
				System.out.println(pq.poll());
		}
	}
}
