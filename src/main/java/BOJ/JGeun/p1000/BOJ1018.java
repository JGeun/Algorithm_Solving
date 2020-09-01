package BOJ.JGeun.p1000;

import java.util.Scanner;

public class BOJ1018 {
	static int N, M;
	static String[] line;
	static String[] map;

	static int changePos(int pos){
		if(pos ==0) return 1;
		else	return 0;
	}
	static int findMin(int Min, int count){
		if(Min > count)
			return count;
		else
			return Min;
	}
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M=sc.nextInt();
		sc.nextLine(); //첫줄 개행문자 제거
		line =new String[2];
		line[0] = "WBWBWBWB"; line[1]="BWBWBWBW";
		map = new String[N];
		for(int a=0; a<N; a++)
			map[a] = sc.nextLine(); 
 
		int FMin=64, SMin=64;
		for(int k=0; k<=N-8; k++){
			for(int n=0; n<=M-8; n++){
				int Fpos=0, Spos=1;
				int Fcount=0, Scount=0;
				for(int i=0; i<8; i++){
					for(int j=0; j<8; j++){
						if(map[i+k].charAt(j+n) != line[Fpos].charAt(j))
							Fcount+=1;
						if(map[i+k].charAt(j+n) != line[Spos].charAt(j))
							Scount+=1;
					}
					Fpos = changePos(Fpos); Spos = changePos(Spos);
				}
				FMin = findMin(FMin, Fcount); SMin = findMin(SMin, Scount);
			}
		}
		
		if(FMin<=SMin)
			System.out.println(FMin);
		else
			System.out.println(SMin);
	}
}
