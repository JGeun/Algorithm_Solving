package BOJ.p1100;

import java.util.Scanner;

public class BOJ1193 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		
		int sum = 0, count = 1;
		
		while(true) {
			if(X <= sum + count) {
				if(count % 2 == 1) {//홀수면 올라감
					System.out.println((count - (X-sum-1) +"/"+ (X-sum) ));
					break;
				}else { //짝수면 내려감
					System.out.println((X-sum) +"/"+  (count - (X-sum-1)));
					break;
				}
			}else {
				sum += (count++);
			}
		}
	}
}
