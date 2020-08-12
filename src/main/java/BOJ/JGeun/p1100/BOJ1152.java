package BOJ.JGeun.p1100;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1152 {
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String words = br.readLine();
        StringTokenizer st = new StringTokenizer(words);
        bw.append(st.countTokens()+"");
        bw.flush();
    }
}
