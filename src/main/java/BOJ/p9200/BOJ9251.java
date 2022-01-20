package BOJ.p9200;

import java.util.Scanner;

public class BOJ9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int[][] map = new int[str1.length()+1][str2.length()+1];
        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    map[i][j] = map[i-1][j-1]+1;
                else
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
            }
        }
        System.out.println(map[str1.length()][str2.length()]);
    }
}
