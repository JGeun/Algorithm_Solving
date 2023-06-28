import java.io.*;

public class Main {

	private static int N, ans = 0;
	private static int[] cols;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		input();
		solve(0);
		System.out.println(ans);
	}

	private static void solve(int row) {
		if (row == N) {
			ans += 1;
			return;
		}

		for (int col=0; col<N; col++) {
			boolean isPossible = true;

			for (int i=0; i<row; i++) {
				if (!isAttackable(row, col, i, cols[i])) continue;
				isPossible = false;
				break;
			}

			if (!isPossible) continue;

			cols[row] = col;
			solve(row+1);
			cols[row] = 0;
		}
	}

	private static boolean isAttackable(int r1, int c1, int r2, int c2) {
		if (c1 == c2) return true;
		if (r1 - c1 == r2 - c2) return true;
		return r1 + c1 == r2 + c2;
	}

	private static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		cols = new int[N];
	}
}
