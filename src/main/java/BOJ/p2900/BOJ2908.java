package BOJ.p2900;

import java.util.*;
import java.io.*;

public class BOJ2908 {
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int A = Integer.parseInt(sb.append(st.nextToken()).reverse().toString());
    	sb.setLength(0);
    	int B = Integer.parseInt(sb.append(st.nextToken()).reverse().toString());
    	
    	if(A > B)
    		bw.append(A+"");
    	else
    		bw.append(B+"");
    	bw.flush();
    }
}
