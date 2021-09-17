package BOJ.JGeun.p3100;

import java.io.*;
import java.util.*;

public class BOJ3190 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, K, L;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static Queue<Info> queue = new LinkedList<>();
    static Deque<Move> deque = new ArrayDeque<>();

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N+1][N+1];
        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 2;
        }
        L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            queue.add(new Info(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }
    }

    static void process(){
        board[1][1] = 1;
        int time = 0;
        int dirIdx = 1;
        int headX=1, headY=1;
        deque.add(new Move(headX, headY));
        while(true){
            if(!queue.isEmpty() && time == queue.peek().time) {
                dirIdx = getDirIdx(dirIdx, queue.peek().dir);
                queue.poll();
            }
            headX += dx[dirIdx]; headY += dy[dirIdx];
            Move headMove = new Move(headX, headY);
            if(headX<1 || headX>N || headY<1 || headY>N) break;
            if(deque.contains(headMove)) break;
            if(board[headY][headX] != 2) deque.pollLast();
            else board[headY][headX] = 0;
            deque.addFirst(headMove);
            time+=1;
        }
        System.out.println(time+1);
    }

    static int getDirIdx(int dirIdx, char dir){
        if(dirIdx == 0){
            if(dir == 'L') return 3;
            else return 2;
        }else if(dirIdx == 1){
            if(dir == 'L') return 2;
            else return 3;
        }else if(dirIdx == 2){
            if(dir == 'L') return 0;
            else return 1;
        }else{
            if(dir == 'L') return 1;
            else return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static class Move{
        public int x, y;

        Move(int _x, int _y){
            this.x = _x; this.y = _y;
        }

        @Override
        public boolean equals(Object v){
            if(v instanceof Move){
                Move move = (Move)v;
                if(move.x == this.x && move.y == this.y) return true;
                else return false;
            }
            return false;
        }
    }
    static class Info{
        public int time;
        public char dir;

        Info(int _time, char _dir){
            this.time = _time; this.dir = _dir;
        }
    }
}
