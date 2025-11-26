/**
 * 1. 반복문을 돌면서 bill에서 가장 큰 수를 절반으로 줄임.
 * 2. 그대로 넣거나 혹은 둘의 순서를 바꿔서 wallet 보다 작은 조건을 만족하면 break
 */
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while (true) {
            if (isBiggerThanWallet(wallet, bill)) break;
            
            if (bill[0] >= bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer += 1;
        }

        return answer;
    }
    
    private boolean isBiggerThanWallet(int[] wallet, int[] bill) {
        return (wallet[0] >= bill[0] && wallet[1] >= bill[1]) ||
            (wallet[0] >= bill[1] && wallet[1] >= bill[0]);
    }
}