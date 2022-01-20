package BOJ.p10800;

import java.util.*;

public class BOJ10845 {
	static Queue<Integer> q = new LinkedList<>();
	static int last;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		for(int i=0; i<N; i++){
			getQueue(sc.nextLine());
		}
	}
	private static void getQueue(String order) {
		StringTokenizer st = new StringTokenizer(order);
		switch(st.nextToken()) {
		case "push":
			int n  = Integer.parseInt(st.nextToken());
			last = n;
			q.offer(n);
			break;
		case "pop":
			if(q.isEmpty())
				System.out.println("-1");
			else
				System.out.println(q.poll());
			break;
		case "size":
			System.out.println(q.size());
			break;
		case "empty":
			if(q.isEmpty())
				System.out.println("1");
			else
				System.out.println("0");
			break;
		case "front":
			if(q.isEmpty())
				System.out.println("-1");
			else
				System.out.println(q.peek());
			break;
		case "back":
			if(q.isEmpty())
				System.out.println("-1");
			else
				System.out.println(last);
			break;
		}
	}
}
