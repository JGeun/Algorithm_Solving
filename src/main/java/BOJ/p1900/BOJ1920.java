package BOJ.p1900;

import java.util.*;

public class BOJ1920 {
	static int[] array;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	array = new int[N];
    	for(int i=0; i<N; i++)
    		array[i] = sc.nextInt();
    	Arrays.sort(array);
    	int M = sc.nextInt();
    	for(int i=0; i<M; i++) {
    		int n = sc.nextInt();
    		System.out.println(BSearch(n));
    	}
    }	
    private static int BSearch(int target) {
    	int low = 0;
    	int high = array.length -1;
    	int mid;
    	
    	while(low <= high) {
    		mid = (low + high)/2;
    		if(array[mid] == target)
    			return 1;
    		else if(array[mid] > target)
    			high = mid -1;
    		else
    			low = mid+1;
    	}
    	return 0;
    }
}
