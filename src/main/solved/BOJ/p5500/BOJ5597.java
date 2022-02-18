package BOJ.p5500;

import java.util.*;

public class BOJ5597 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<28; i++) {
        	int n = sc.nextInt();
        	list.add(n);
        }
        for(int i=1; i<=30; i++) {
        	if(!list.contains(i))
        		System.out.println(i);
        }
    }
}
