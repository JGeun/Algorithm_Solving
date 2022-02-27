package Programmers.level2.java;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int index;
        int move = length - 1;

        for(int i = 0; i < name.length(); i++){
            //스틱 상, 하 움직임
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }
            //스틱 좌, 우
            //left->right였기에 좌측으로 이동하여 넘어가기 위해서
            //i+i+length-index => (이동한 위치-현재위치)*2 + 다음 알파벳이 존재하는 위치
            move = Math.min(move, i * 2 + length - index);
            // right 끝에서 좌측으로 이동하였기에 다시 처음 위치로 돌아가고 싶으면
            // (length-index)*2+i
            move = Math.min(move, (length - index) * 2 + i);

        }
        return answer + move;
    }
}
