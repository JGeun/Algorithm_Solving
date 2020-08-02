package BOJ.JGeun.p2700;

import java.util.*;

public class BOJ2753 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int year = s.nextInt();
		boolean isLeap = false;
 
		if((year%4 == 0) && ((year%100!=0) || (year%400==0))){
			isLeap = true;
		}
 
		if(isLeap)
			System.out.println("1");
		else
			System.out.println("0");
	}
}
