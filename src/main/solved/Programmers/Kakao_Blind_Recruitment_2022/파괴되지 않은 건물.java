package Programmers.Kakao_Blind_Recruitment_2022;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0, N = board.length, M = board[0].length;
        int[][] temp = new int[N+1][M+1];

        for(int i=0; i<skill.length; i++){
            temp[skill[i][1]][skill[i][2]] += skill[i][0] == 1 ? -skill[i][5] : skill[i][5];
            temp[skill[i][1]][skill[i][4]+1] += skill[i][0] == 1 ? skill[i][5] : -skill[i][5];
            temp[skill[i][3]+1][skill[i][2]] += skill[i][0] == 1 ? skill[i][5] : -skill[i][5];
            temp[skill[i][3]+1][skill[i][4]+1] += skill[i][0] == 1 ? -skill[i][5] : skill[i][5];
        }

        for(int i=0; i<N+1; i++){
            for(int j=0; j<M; j++){
                temp[i][j+1] += temp[i][j];
            }
        }

        for(int j=0; j<M+1; j++){
            for(int i=0; i<N; i++){
                temp[i+1][j] += temp[i][j];
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] + temp[i][j] >= 1) answer+=1;
            }
        }

        return answer;
    }
}
