import java.util.*;

class Solution {
    private int MAX = 500001;
    private int[][] town;
    private int[] distance;
    private boolean[] visit;
    private int count = 1;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        init(N, road);

        dijstra(1, N);

        for(int i=1; i<=N; i++){
            if(distance[i] <= K)
                answer += 1;
        }
        return answer;
    }

    public void dijstra(int point, int N){
        if(count == N){
            return;
        }

        visit[point] = true;
        count += 1;

        for(int i=1; i<=N; i++){
            if((i != point && town[point][i] != MAX) && (distance[i] > distance[point] + town[point][i])){
                distance[i] = distance[point] + town[point][i];
            }
        }

        int visitPoint = point;
        int minValue = MAX;
        for(int i=2; i<=N; i++){
            if(!visit[i] && minValue > distance[i]){
                minValue = distance[i];
                visitPoint = i;
            }
        }

        dijstra(visitPoint, N);
    }

    public void init(int N, int[][] road){
        town = new int[N+1][N+1];
        distance = new int[N+1];
        visit = new boolean[N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i == j)
                    town[i][j] = 0;
                else
                    town[i][j] = MAX;
            }
        }

        for(int i=0; i<road.length; i++){
            if(town[road[i][0]][road[i][1]] > road[i][2]){
                town[road[i][0]][road[i][1]] = road[i][2];
                town[road[i][1]][road[i][0]] = road[i][2];
            }
        }

        for(int i=2; i<=N; i++)
            distance[i] = MAX;
    }
}