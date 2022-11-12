class Solution{
    public int solution(int[][] board){
        int height = board.length;
        int width = board[0].length;

        for(int i=1; i<height; i++){
            for(int j=1; j<width; j++){
                if(board[i][j] != 0){
                    int min = Math.min(board[i-1][j-1], board[i-1][j]);
                    min = Math.min(board[i][j-1], min);
                    board[i][j] = min+1;
                }
            }
        }

        int max = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++)
                if(max < board[i][j])
                    max = board[i][j];
        }
        return max*max;
    }
}