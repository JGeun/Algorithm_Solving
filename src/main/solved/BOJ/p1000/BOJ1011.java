package BOJ.p1000;

import java.util.Scanner;

public class BOJ1011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			long x = sc.nextLong();
			long y = sc.nextLong();
			long length = y - x;

			long std = 1;
			do {
				std += 1;
			} while (std * std <= length);

			if ((std - 1) * (std - 1) == length)
				System.out.println(((std - 1) * (std - 1)) - ((std - 2) * (std - 2)));
			else {
				long value = std * std - (std - 1) * (std - 1);
				if (std * std - std >= length)
					System.out.println(value - 1);
				else
					System.out.println(value);
			}
		}
	}
}
