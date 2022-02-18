package BOJ.p4300;

import java.util.Scanner;

public class BOJ4344 {
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int C =Integer.parseInt(sc.nextLine());
		for(int i=0; i<C; i++) {
			int N =sc.nextInt();
			
			int[] stu = new int[N];
			int sum = 0;
			for(int j=0; j<N; j++) {
				stu[j] = sc.nextInt();
				sum += stu[j];
			}
			float avg = (float)sum/N;
			
			int num = 0;
			for(int j=0; j<N; j++) {
				if(stu[j]>avg)
					num+=1;
			}
			System.out.println(String.format("%.3f", (float)num*100/N) + "%");
		}
	}
}
