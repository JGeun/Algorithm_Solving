package BOJ.p2600;

import java.io.*;
import java.util.*;

public class BOJ2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, wCnt=0, bCnt=0;
    static int[][] board;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    static void process(){
        checkBoard(0, 0, N);
    }

    static void checkBoard(int x, int y, int size){
        if(size == 0) return;
        if(isAllSameColor(x, y, size, board[x][y])){
            if(board[x][y] == 1) bCnt+=1;
            else wCnt += 1;
            return;
        }
        checkBoard(x,y,size/2);
        checkBoard(x+size/2, y, size/2);
        checkBoard(x, y+size/2, size/2);
        checkBoard(x+size/2, y+size/2, size/2);
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
        sb.append(wCnt).append('\n').append(bCnt);
        System.out.println(sb);
    }

    static class Node implements Comparable<Node>{
        int idx, weight;

        Node(int _to, int _weight){
            this.idx = _to; this.weight = _weight;
        }

        @Override
        public int compareTo(Node n){
            return this.weight - n.weight;
        }
    }
}
