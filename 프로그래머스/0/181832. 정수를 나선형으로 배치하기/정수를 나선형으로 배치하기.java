class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int level = 0;
        int index = 1;
        
        while (index <= n * n) {
            for (int x=level; x<n-level; x++) {
                answer[level][x] = index++;
            }
            
            for (int y=level+1; y<n-level; y++) {
                answer[y][n-level-1] = index++;
            }
            
            for (int x=n-1-level-1; x>=level; x--) {
                answer[n-1-level][x] = index++;
            }
            
            for (int y=n-1-level-1; y>level; y--) {
                answer[y][level] = index++;
            }
            
            level += 1;
        }
        return answer;
    }
}