package BOJ.p1700;

import java.io.*;
import java.util.*;

public class BOJ1780 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[] cnt;
    static int[][] board;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        cnt = new int[3];
        board = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    static void process(){
        checkBoard(0, 0, N);
        for(int i=0; i<3; i++) sb.append(cnt[i]).append('\n');
        System.out.print(sb);
    }

    static void checkBoard(int x, int y, int size){
        if(size == 0) return;
        if(isAllSameColor(x, y, size, board[x][y])){
            cnt[board[x][y]+1]+=1;
            return;
        }else{
            size /=3 ;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    checkBoard(x+i*size, y+j*size, size);
                }
            }
        }
    }

    static boolean isAllSameColor(int x, int y, int size, int color){
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++)
                if(board[i][j] != color) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
