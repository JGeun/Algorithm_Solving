package BOJ.p17200;

import java.io.*;
import java.util.*;

public class BOJ17281 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");
    static StringBuilder sb = new StringBuilder("");

    static int N, score=Integer.MIN_VALUE, SIZE=9;
    static int[] order, base;
    static boolean[] visit;
    static int[][] inning;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        order = new int[SIZE+1];
        visit = new boolean[SIZE+1];
        base = new int[4];
        inning = new int[N+1][SIZE+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=SIZE; j++) inning[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    static void process() {
        order[4] = 1;
        visit[4] = true;
        getOrder(2);
        System.out.println(score);
    }

    static void getOrder(int cnt){
        if(cnt == SIZE+1){
            Arrays.fill(base, 0);
            score = Math.max(score, getScore());
            return;
        }

        for(int i=1; i<=SIZE; i++){
            if(!visit[i]){
                visit[i] = true;
                order[i] = cnt;
                getOrder(cnt+1);
                order[i] = 0;
                visit[i] = false;
            }
        }
    }

    static int getScore(){
        int out = 0, inn = 1, sum = 0, num=1;

        while(inn <= N){
            if(inning[inn][order[num]] == 1){
                checkBase(1);
                sum += base[3];
                base[3] = 0;
            }
            else if(inning[inn][order[num]] == 2){
                checkBase(2);
                sum += base[3];
                base[3] = 0;
            }else if(inning[inn][order[num]] == 3){
                checkBase(3);
                sum += base[3];
                base[3] = 0;
            }else if(inning[inn][order[num]] == 4){
                checkBase(4);
                sum += (base[3]);
                base[3] = 0;
            }
            else{
                out += 1;
            }
            num = (num+1)%10 == 0 ? 1 : (num+1)%10;
            if(out == 3){
                inn+=1;
                out = 0;
                Arrays.fill(base, 0);
            }
        }

        return sum;
    }

    static void checkBase(int hit){
        for(int i=2; i>=0; i--){
            if(base[i] == 1){
                base[i] = 0;
                base[Math.min(i + hit, 3)] += 1;
            }
        }
        base[hit-1] += 1;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
