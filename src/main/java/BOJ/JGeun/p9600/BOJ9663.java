package BOJ.JGeun.p9600;

import java.util.Scanner;

public class BOJ9663 {
	static boolean[] flag_a;
	static boolean[] flag_b;
	static boolean[] flag_c;
	static int[] pos;
	static int count = 0;
	
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		pos = new int[N];
		flag_a = new boolean[N];
		flag_b = new boolean[N*2-1];
		flag_c = new boolean[N*2-1];
		set(N, 0);
		System.out.println(count);
	}
	static void set(int N, int i) {
		for(int j=0; j<N; j++) {
			if(flag_a[j] == false && flag_b[i+j] == false && flag_c[i-j+N-1] == false) {
				pos[i] = j;
				if(i == N-1) {
					count+=1;
				}
				else {
					flag_a[j] = flag_b[i+j] = flag_c[i-j+N-1] = true;
					set(N, i+1);
					flag_a[j] = flag_b[i+j] = flag_c[i-j+N-1] = false;
				}
			}
		}
	}
}
