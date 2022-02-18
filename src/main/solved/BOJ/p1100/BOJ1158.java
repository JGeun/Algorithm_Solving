package BOJ.p1100;

import java.util.*;

public class BOJ1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt();
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1; i<=N; i++)
			list.offer(i);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int count = 0;
		boolean isPush = false;
		while(true) {
			isPush = false;
			int n = list.poll();
			count+=1;
			if(count == K) {
				count = 0;
				isPush = true;
				sb.append(n);
			}
			else
				list.offer(n);
			
			if(list.size() == 0)
				break;
			
			if(isPush)
				sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb);
	}
}
