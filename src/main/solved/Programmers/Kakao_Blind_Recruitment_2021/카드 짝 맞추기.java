package Programmers.Kakao_Blind_Recruitment_2021;

import java.util.*;

class Solution {
    private int[] dc = {-1, 1, 0, 0};
    private int[] dr = {0, 0, -1, 1};

    public int solution(int[][] board, int r, int c) {
        return process(board, r, c);
    }

    private int process(int[][] board, int r, int c){
        if(isFinished(board)) return 0;

        int answer = Integer.MAX_VALUE;

        for(int k=1; k<=6; k++){
            ArrayList<Point> list = new ArrayList<>();
            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    if(board[i][j] == k){
                        list.add(new Point(i, j));
                    }
                }
            }

            if(list.isEmpty()) continue;

            int case1 = getDist(board, r, c, list.get(0).r, list.get(0).c)
                    + getDist(board, list.get(0).r, list.get(0).c, list.get(1).r, list.get(1).c) + 2;

            int case2 = getDist(board, r, c, list.get(1).r, list.get(1).c)
                    + getDist(board, list.get(1).r, list.get(1).c, list.get(0).r, list.get(0).c) + 2;


            board[list.get(0).r][list.get(0).c] = 0;
            board[list.get(1).r][list.get(1).c] = 0;

            answer = Math.min(answer, Math.min(case1+process(board, list.get(1).r, list.get(1).c),
                    case2+process(board, list.get(0).r, list.get(0).c)));

            board[list.get(0).r][list.get(0).c] = k;
            board[list.get(1).r][list.get(1).c] = k;
        }
        return answer;
    }

    private int getDist(int[][] board, int r1, int c1, int r2, int c2){
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];
        queue.add(new Point(r1, c1, 0));
        visited[r1][c1] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            if(p.r == r2 && p.c == c2){
                return p.move;
            }

            for(int i=0; i<4; i++){
                int fr = p.r+dr[i];
                int fc = p.c+dc[i];
                if(isRange(fr,fc) && !visited[fr][fc]){
                    visited[fr][fc] = true;
                    queue.add(new Point(fr, fc, p.move+1));
                }

                while(isRange(fr+dr[i], fc+dc[i])){
                    if(board[fr][fc] != 0) break;
                    fr += dr[i];
                    fc += dc[i];
                }

                if(isRange(fr,fc) && !visited[fr][fc]){
                    visited[fr][fc] = true;
                    queue.add(new Point(fr, fc, p.move+1));
                }
            }
        }
        return 0;
    }

    private boolean isFinished(int[][] board){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(board[i][j] != 0) return false;
            }
        }
        return true;
    }
    private boolean isRange(int y, int x){
        return y>=0 && x>=0 && y<4 && x < 4;
    }

    class Point{
        int r, c, move;
        public Point(int r, int c){
            this.r = r; this.c = c;
        }

        public Point(int r, int c, int move){
            this.r = r; this.c = c; this.move = move;
        }
    }
}
