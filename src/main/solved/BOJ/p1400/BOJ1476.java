package BOJ.p1400;

import java.util.Scanner;

public class BOJ1476 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int E = sc.nextInt(), S=sc.nextInt(), M=sc.nextInt();
		
		int num=1;
		int comE=1, comS=1, comM=1;
		while(true){
			if(comE == 16)
				comE = 1;
			if(comS == 29)
				comS = 1;
			if(comM == 20)
				comM = 1;
			
			if(E == comE && S == comS && M == comM){
				System.out.println(num);
				break;
			}
			comE +=1; comS +=1; comM +=1;
			num+=1;
		}
	}
}
