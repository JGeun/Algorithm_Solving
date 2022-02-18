package BOJ.p5600;

import java.io.*;

public class BOJ5622 {
	static int[] alpha;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String dial = br.readLine();

    	setAlpha();
    	
    	int count = 0;
    	for(int i = 0; i<dial.length(); i++)
    		count += alpha[dial.charAt(i)-'A']+1;
    	
    	System.out.println(count);
    }
    private static void setAlpha() {
    	alpha = new int[26];
    	
    	int num = 2;
    	int count = 0;
    	for(int i=0; i<26; i++) {
    		alpha[i] = num;
    		count +=1;
    		if(num == 7 || num == 9){		
    			if(count == 4) {
    				count = 0;
    				num +=1;
    			}
    		}else {
    			if(count == 3) {
    				count = 0;
    				num += 1;
    			}
    		}	
    	}
    }
}
