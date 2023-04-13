// 1. 시간복잡도가 길이 1000000 이기 때문에 O(N)으로 충분합니다.
// 2. end가 쭉 타고 가면서 sum에 더해줄 때 sum이 K를 넘으면 Start를 떙겨오는 방식으로 찾습니다.
// 4. 2번을 반복하면서 start와 end의 차이가 제일 적은 경우를 찾습니다.
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0] = 0; answer[1] = 1000001;

        int sum = 0;
        int start = 0;
        int end = 0;

        while (end < sequence.length) {
            sum += sequence[end++];

            if (sum == k && end-start-1 < answer[1] - answer[0]) {
                answer[0] = start;
                answer[1] = end;
            }

            while (sum-sequence[start] >= k && start <= end) {
                sum -= sequence[start++];
            }

            if (sum == k && end-start-1 < answer[1] - answer[0]) {
                answer[0] = start;
                answer[1] = end-1;
            }
        }

        return answer;
    }
}