import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        ArrayList<Stack<Integer>> machine = new ArrayList<>();

        int length = board.length;

        for(int i=0; i<length; i++){ //첫번째 줄부터
            Stack<Integer> line = new Stack<>();
            for(int j=length-1; j>=0; j--){ //아래에서부터
                if(board[j][i] != 0)
                    line.push(board[j][i]);
            }
            machine.add(line);
        }

        for(int i=0; i<moves.length; i++){
            Stack<Integer> line = machine.get(moves[i]-1);
            if(!line.isEmpty()){
                int doll = line.pop();
                if(!basket.isEmpty() && basket.peek() == doll){
                    basket.pop();
                    answer += 2;
                }
                else
                    basket.push(doll);
            }
        }
        return answer;
    }
}