package BOJ.p2400;

import java.util.Scanner;

public class BOJ2490 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<3; i++) {
			int zero = 0, one =0;
			for(int j=0; j<4; j++) {
				int n = sc.nextInt();
				if(n == 0)
					zero+=1;
				else
					one +=1;
			}
			if(zero == 4)
				System.out.println("D");
			else if(zero == 3)
				System.out.println("C");
			else if(zero == 2)
				System.out.println("B");
			else if(zero == 1)
				System.out.println("A");
			else
				System.out.println("E");
		}
	}
}
