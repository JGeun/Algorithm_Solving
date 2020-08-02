package BOJ.JGeun.p10900;

import java.util.*;

public class BOJ10953 {
	public static void main(String[] args){ 
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<T; i++) {
			String line = sc.nextLine();
			StringTokenizer st = new StringTokenizer(line,",");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			System.out.println(A+B);
		}
	}
}
