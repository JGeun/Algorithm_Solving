package BOJ.JGeun.p1000;

import java.util.Scanner;

public class BOJ1085 {
	static int getLen(int pos, int bor){
		if(pos>bor-pos)
			return bor-pos;
		else
			return pos; 
	}
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int x =sc.nextInt(), y=sc.nextInt(), w=sc.nextInt(), h=sc.nextInt();
		int LenX=getLen(x,w), LenY=getLen(y,h);
		if(LenX >= LenY)
			System.out.println(LenY);
		else
			System.out.println(LenX);
	}
}
