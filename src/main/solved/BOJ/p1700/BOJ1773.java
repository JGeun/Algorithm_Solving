package BOJ.p1700;


import java.util.*;

public class BOJ1773{
  public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), C=sc.nextInt();
		boolean[] time = new boolean[C+1];
		for(int i=0; i<N; i++) {
			int t = sc.nextInt();
			int j=1;
			while(t*j<=C) {
				time[t*j] = true;
				j+=1;
			}
		}
		int count =0;
		for(int i=1; i<=C; i++) {
			if(time[i])
				count+=1;
		}
		System.out.println(count);
	}
}
