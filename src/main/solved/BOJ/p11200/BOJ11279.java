import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				sb.append(!pq.isEmpty() ? pq.poll() : 0).append("\n");
			} else {
				pq.offer(num);
			}
		}
		System.out.print(sb.toString());
	}
}