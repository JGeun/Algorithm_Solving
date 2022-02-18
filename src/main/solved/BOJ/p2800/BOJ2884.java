package BOJ.p2800;

import java.util.*;

public class BOJ2884 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int H =s.nextInt();
		int M = s.nextInt();

		if(M>=45)
			System.out.println(H + " " + (M-45));
		else{
			if(H==0)
				System.out.println("23 " + (60-(45-M)));
			else
				System.out.println(H-1 + " " + (60-(45-M)));
		}
	}
}
