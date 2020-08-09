package BOJ.JGeun.p4600;

public class BOJ4673 {
	public static void main(String[] args) {
		int[] num = new int[10001];
		
		for(int i=1; i<=10000; i++) {
			int n = getSelf(i);
			if(n <= 10000) {
				num[n] = 1;
			}
		}
		for(int i=1; i<=10000; i++) {
			if(num[i] == 0)
				System.out.println(i);
		}
	}
	
	private static int getSelf(int n) {
		int num = n;
		if (n >= 10000) {
			num += n / 10000; n %= 10000;
		}
		if (n >= 1000) {
			num += n / 1000; n %= 1000;
		}
		if (n >= 100) {
			num += n / 100; n %= 100;
		}
		if (n >= 10) {
			num += n / 10; n %= 10;
		}
		return num + n;
	}
}
