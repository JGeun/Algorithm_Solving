package BOJ.p15500;

public class BOJ15596 {
	long sum(int[] a) {
        long ans = 0;
        for(int i=0; i<a.length; i++)
			ans += a[i];
        return ans;
    }
}
