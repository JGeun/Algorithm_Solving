package BOJ.p23200;

import java.io.*;
import java.util.*;

public class BOJ23291 {
    private static int[][] block;
    private static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        block = new int[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) block[0][i] = Integer.parseInt(st.nextToken());

        int ans = 0;

        while (!isSuccess()){
            blockProcess();
            ans += 1;
        }

        System.out.println(ans);
    }

    private static boolean isSuccess() {
        int max=Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(block[i][j] == 0) continue;
                max = Math.max(max, block[i][j]);
                min = Math.min(min, block[i][j]);
            }
        }
        return max - min <= K;
    }

    private static void blockProcess() {
        push2Min();
        rotateBlocks();
        adjustBlocks();
        arrangeBlocks();
        foldBlocks();
        adjustBlocks();
        arrangeBlocks();
    }

    private static void push2Min() {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) min = Math.min(min, block[0][i]);
        for(int i=0; i<N; i++) if(block[0][i] == min) block[0][i]+=1;
    }

    private static void rotateBlocks() {
        int width=1, height=1, start = 1; //start: N줄의 처음 시작 위치
        int index = 0; //짝수일 때는 width가 늘어나고, 홀수일 땐 height가 늘어남

        while(start + height - 1  < N){
            index+=1;
            for(int y=0; y<height; y++){
                for(int x=start-width; x<start; x++){
                    block[start-x][start+y] = block[y][x];
                    block[y][x] = 0;
                }
            }
            start+=height;

            if(index%2==0) width+=1;
            else height+=1;
        }
    }

    private static void adjustBlocks() {
        int[][] temp = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                calcDiff(temp, i, j, i+1, j);
                calcDiff(temp, i, j, i, j+1);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                block[i][j] += temp[i][j];
            }
        }
    }

    private static void arrangeBlocks() {
        int[] temp = new int[N];
        int idx = 0;

        for(int x =0; x<N; x++){
            for(int y=0; y<N; y++){
                if(block[y][x] != 0){
                    temp[idx++] = block[y][x];
                    block[y][x] = 0;
                }
            }
        }

        for(int i=0; i<N; i++) block[0][i] = temp[i];
    }

    private static void foldBlocks() {

        for(int i=0; i<N/4; i++){
            block[1][N-1-i] = block[0][i];
            block[0][i] = 0;
        }

        for(int i=0; i<N/4; i++){
            block[2][N/4*3+i] = block[0][N/4+i];
            block[0][N/4+i] = 0;
        }

        for(int i=0; i<N/4; i++){
            block[3][N-1-i] = block[0][N/2+i];
            block[0][N/2+i] = 0;
        }
    }

    private static void calcDiff(int[][] temp, int n1, int p1, int n2, int p2){
        if(block[n1][p1] == 0) return;
        if(block[n2][p2] == 0) return;

        int value = Math.abs(block[n1][p1] - block[n2][p2])/5;
        if(block[n1][p1] > block[n2][p2]){
            temp[n1][p1] -= value;
            temp[n2][p2] += value;
        }else{
            temp[n2][p2] -= value;
            temp[n1][p1] += value;
        }
    }
}
