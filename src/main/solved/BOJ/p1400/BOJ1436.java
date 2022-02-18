package BOJ.p1400;

import java.util.Scanner;

public class BOJ1436 {
	static int N;
	static void findNumPrint(){
		String find="666";
		if(N==1){
			System.out.println(find);
		}
		else{
			int front=1;
			int count=1;
			do{
				String strN=String.valueOf(front).concat(find);
				int blank=0; //666ã�� �� ���� ������ ����
				for(int i=0; i<strN.length()-2; i++){
					String subN=strN.substring(i,i+3); //3����
					if(subN.equals(find)){
						blank = (strN.length()-1)-(i+2);	
						strN = strN.substring(0,i+3); //666ã��ĭ���� �ֱ�
						break;
					}	
				}
				if(blank!=0){
					for(int j=0; j<Math.pow(10,blank); j++){
						count+=1;
						if(count == N){
							String plus =String.valueOf(j);
							for(int i=0; i<blank-plus.length();i++)
								strN=strN.concat(String.valueOf("0"));
							strN=strN.concat(String.valueOf(j));
							break;
						}
					}
					front+=1;
				}
				else{
					count+=1;
					front+=1;
				}
				if(N == count)
					System.out.println(strN);
			}while(N!=count);
		}
	}
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		findNumPrint();
	}
}
