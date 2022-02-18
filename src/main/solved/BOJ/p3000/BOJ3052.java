package BOJ.p3000;

import java.util.*;

public class BOJ3052 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for(int i=1; i<=10; i++){
			int num = sc.nextInt();
			num = num%42;
			boolean isEleExt = false;
			for(int j=0; j<array.size(); j++){
				if(num == array.get(j)){
					isEleExt = true;
					break;
				}
			}
			if(!isEleExt)
				array.add(num);
		}
		System.out.println(array.size());
	}
}
