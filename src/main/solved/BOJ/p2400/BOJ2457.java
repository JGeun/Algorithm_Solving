package BOJ.p2400;

import java.io.*;
import java.util.*;

class BOJ2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] flowers = new int[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++)
                flowers[i][j] = Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken());
        }

        Arrays.sort(flowers, (f1, f2) -> {
            if(f1[0] != f2[0]) return f1[0] - f2[0];
            return f1[1] - f2[1];
        });

        int ans = 0, date = 301, findIndex = -1;
        while(date <= 1130){
            boolean findDate = false;
            int maxDate = date;
            for(int i=findIndex+1; i<N; i++){
                if((flowers[i][0] <= date && date <= flowers[i][1] && maxDate < flowers[i][1])) {
                    maxDate = flowers[i][1]; findDate = true;
                    findIndex = i;
                }
            }
            if(!findDate) break;
            ans+=1; date = maxDate;
        }

        if(date <= 1130) System.out.println(0);
        else System.out.println(ans);
    }
}

