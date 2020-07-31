package BOJ.JGeun.p1700;

import java.io.*;
import java.util.*;

public class BOJ1764 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		Set<String> list = new HashSet<>();
		ArrayList<String> offset = new ArrayList<>();
		
		for(int i=0; i<N; i++) 
			list.add(br.readLine());
		
		for(int i=0; i<M; i++) {
			String name = br.readLine();
			if(list.contains(name))
				offset.add(name);
		}
		Collections.sort(offset);
		
		bw.write(offset.size() + "\n");
        for(String s : offset){
            bw.write(s + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
	}
}
