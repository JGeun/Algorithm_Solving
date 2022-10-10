import java.util.*;

/* 이 문제는 1~card 길이까지 한번 반복하면서 그룹의 최댓값을 뽑아내는 문제
visited 배열을 토대로 처리, 매개변수는 1번, 2번, 3번 그룹 체그하는 group 필요, 시작점 start 필요
현재 정답률 60.0, 실패 케이스: 4, 7, 8, 10
*/

// 8 6 3 7 2 5 1 4
// 0 6 3 0 2 5 0 0

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        for (int i=0; i<cards.length; i++) {
            boolean[] visited = new boolean[cards.length];
            int first = findCnt(cards, i, 0, visited);
            int second = 0;
            for (int j=0; j<cards.length; j++) {
                if (!visited[j]) {
                    boolean[] visitedClone = visited.clone();
                    second = findCnt(cards, j, 0, visitedClone);
                }
            }
            answer = Math.max(first*second, answer);
        }

        return answer;
    }

    private int findCnt(int[] cards, int start, int group, boolean[] visited) {

        int idx  = start, cnt = 1;
        while (true) {
            visited[idx] = true;
            int boxValue = cards[idx]-1;
            if (visited[boxValue]) {
                break;
            }
            cnt += 1;
            idx = boxValue;
        }

        return cnt;
    }
}