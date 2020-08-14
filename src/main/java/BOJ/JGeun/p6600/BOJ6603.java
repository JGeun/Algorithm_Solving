package BOJ.JGeun.p6600;

import java.util.Scanner;

public class BOJ6603 {
	static int[] num;
	static int[] visit;
	static int k;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	visit = new int[7];
		visit[0] = -1;
		
    	while(true) {
    		k = sc.nextInt();
    		if(k == 0)
    			break;
    		num = new int[k];
    		for(int i=0; i<k; i++)
    			num[i] = sc.nextInt();
    		
    		getLotto(0);
    		System.out.println();
    	}
    }
    private static void getLotto(int d) {
    	if(d == 6) {
    		for(int i=1; i<=6; i++)
    			System.out.print(num[visit[i]]+ " ");
    		System.out.println();
    	}else {
    		for(int i=visit[d]+1; i<k; i++) {
    			visit[d+1] = i;
    			getLotto(d+1);
    			visit[d+1] = -1;
    		}
    	}
    }
}
