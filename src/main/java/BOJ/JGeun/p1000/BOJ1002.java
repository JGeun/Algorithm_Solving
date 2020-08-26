package BOJ.JGeun.p1000;

import java.util.Scanner;

public class BOJ1002 {
	public static int getCount(double length, int r1, int r2) {
		int rSum = r1+r2;
		int rSub = r1 > r2 ? r1-r2 : r2-r1;
		
		if(length==0 && rSub == 0) //구가 동일
			return -1;
		else if(length == 0 && rSub != 0) //한쪽의 구가 안에 포함,접점X
			return 0;
		else if(length == rSum || length == rSub) //접점이 한개
			return 1;
		else if(length < rSum && length > rSub) //접점이 두개
			return 2;
		else
			return 0;
	}
	
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int x1 = sc.nextInt(), y1 = sc.nextInt(), r1 = sc.nextInt(), 
					x2 = sc.nextInt(), y2 = sc.nextInt(), r2 = sc.nextInt();  
			double length = Math.sqrt((Math.pow(y2-y1,2) + Math.pow(x2-x1, 2)));
			System.out.println(getCount(length, r1, r2));
		}
	}
}
