class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i=0; i<balls.length; i++) {
            int[] ball = balls[i];

            int res = Integer.MAX_VALUE;

            // 우측 벽면 맞추기
            if (!(startY == ball[1] && startX <= ball[0])) {
                int h = Math.abs(ball[1]-startY);
                int w = (m-startX)+(m-ball[0]);
                res = Math.min(res, h*h+w*w);
            }

            // 좌측 벽면 맞추기
            if (!(startY == ball[1] && startX >= ball[0])) {
                int h = Math.abs(ball[1]-startY);
                int w = startX+ball[0];
                res = Math.min(res, h*h+w*w);
            }

            // 위쪽 벽면 맞추기
            if (!(startX == ball[0] && startY <= ball[1])) {
                int w = Math.abs(ball[0]-startX);
                int h = (n-startY)+(n-ball[1]);
                res = Math.min(res, h*h+w*w);
            }

            // 아래쪽 벽면 맞추기
            if (!(startX == ball[0] && startY >= ball[1])) {
                int w = Math.abs(ball[0]-startX);
                int h = startY+ball[1];
                res = Math.min(res, h*h+w*w);
            }

            // 양 꼭지점은 구현 예정

            answer[i] = res;
        }
        return answer;
    }
}