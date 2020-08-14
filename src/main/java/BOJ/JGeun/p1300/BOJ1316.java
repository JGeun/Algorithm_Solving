package BOJ.JGeun.p1300;

import java.io.*;

public class BOJ1316 {
	static int[] alpha;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int count = 0;
    	for(int i=0; i<N; i++) {
    		String word = br.readLine();
    		alpha = new int[26];
    		
    		char ch = '?';
    		boolean isCont = true;
    		for(int j=0; j<word.length(); j++) {
    			if(ch != word.charAt(j)) {
    				ch = word.charAt(j);
    				if(alpha[ch-'a'] != 0) {
    					isCont = false;
    					break;
    				}
    				else
    					alpha[ch-'a']+=1;
    			}else {
    				continue;
    			}
    		}
    		if(isCont)
    			count +=1;
    	}
    	System.out.println(count);
    }
}
