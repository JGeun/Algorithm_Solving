package BOJ.JGeun.p9000;

import java.util.Scanner;

public class BOJ9020 {
	static int T;
	static int arr[];
	static int size=10001;
	static void init_arr(){
		arr = new int[size];
		arr[0] = 0; arr[1] =0;
		for(int i=2; i<size; i++)
			arr[i] = i;
	}
	static void getEra(){
		init_arr();
		for(int i=2; i<size; i++){
			if(arr[i] == 0)
				continue;
			int mul=2;
			while(size-1>=i*mul){
				arr[i*mul] = 0;
				mul+=1;
			}
		}
	}
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		getEra();
		for(int i=0; i<T; i++){
			int n = sc.nextInt();
			for(int j=n/2; j>=2; j--){
				if(arr[j]!=0 && arr[n-j]!=0){
					System.out.println(arr[j] +" " +arr[n-j]);
					break;	
				}
			}
		}
	}
}
