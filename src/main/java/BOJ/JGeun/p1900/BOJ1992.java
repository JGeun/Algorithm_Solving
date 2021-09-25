package BOJ.JGeun.p1900;

import java.io.*;
import java.util.*;

public class BOJ1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[][] board;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i=0; i<N; i++){
            String[] numSplit = br.readLine().split("");
            for(int j=0; j<N; j++)
                board[i][j] = Integer.parseInt(numSplit[j]);
        }
    }

    static void process(){
        checkBoard(0, 0, N);
        System.out.println(sb);
    }

    static void checkBoard(int x, int y, int size){
        if(size == 0) return;
        if(isAllSameColor(x, y, size, board[x][y])){
            sb.append(board[x][y]);
            return;
        }else{
            sb.append("(");
            size /=2 ;
            checkBoard(x, y, size);
            checkBoard(x, y + size, size);
            checkBoard(x + size, y, size);
            checkBoard(x + size, y + size, size);
            sb.append(")");
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
