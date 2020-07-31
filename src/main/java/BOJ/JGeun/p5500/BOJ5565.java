package BOJ.JGeun.p5500;

import java.util.Scanner;

public class BOJ5565 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int zero=0, one=0;
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			if(num == 0)
				zero +=1;
			else
				one+=1;
		}
		if(zero > one)
			System.out.println("Junhee is not cute!");
		else
			System.out.println("Junhee is cute!");
	}
}
