
package BOJ.Heewook.sort;

import java.util.*;

public class Sort1427 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num = Integer.valueOf(scanner.nextInt());
		ArrayList<Integer> list = new ArrayList<>();

		while (num > 0){
			list.add(num % 10);
			num /= 10;
		}

		Collections.sort(list, Collections.reverseOrder());
 
		for (int i : list) 
			System.out.print(i);
	}

}
