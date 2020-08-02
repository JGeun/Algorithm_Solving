package BOJ.JGeun.p11000;

import java.util.*;

public class BOJ11022 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int i=1; i<=T; i++){
			int A = s.nextInt();
			int B = s.nextInt();
			System.out.println("Case #"+i+": "+ A +" + "+ B + " = " + (A+B));
		}
	}
}
