package Programmers.Kakao_Winter_Intership_2019;

class Soultion {
    public int solution(int[] stones, int k) {
        int answer = 0, max = -1, min = 200000001;

        for(int stone : stones){
            max = Math.max(max, stone);
            min = Math.min(min, stone);
        }

        return binarySearch(stones, k, min, max);
    }

    private int binarySearch(int[] stones, int k, int low, int high){
        if(low == high) return low;

        while(low < high){
            int mid = (low+high)/2;

            if(canCross(stones, k, mid)){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        return low - 1;
    }

    private boolean canCross(int[] stones, int k, int friends){
        int passCount = 0;

        for(int stone : stones){
            if(stone - friends < 0) passCount += 1;
            else passCount = 0;

            if(passCount == k) return false;
        }
        return true;
    }
}
