package BOJ.JGeun.p1700;

import java.io.*;

public class BOJ1748 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=1; i<=N; i*=10) {
        	count += N - (i-1);
        }
        System.out.println(count);
    }
}
