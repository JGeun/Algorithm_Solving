package BOJ.JGeun.p7500;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7562 {
    private static int len;
    private static int[][] map;
    private static int[] pos = new int[2];
    private static int[] goal = new int[2];
    private static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int count = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            count = 0;
            len = sc.nextInt();
            map = new int[len][len];
            for(int j=0; j<len; j++)
                Arrays.fill(map[j], Integer.MAX_VALUE);
            pos[0] = sc.nextInt(); pos[1] = sc.nextInt();
            goal[0] = sc.nextInt(); goal[1] = sc.nextInt();
            bfs(pos[1], pos[0], 0);
            System.out.println(count);
        }
    }

    private static void bfs(int y, int x, int n) {
        Queue<int[]> queue = new LinkedList<>();
        map[y][x] = 0;
        queue.offer(new int[]{x,y,n});
        while(!queue.isEmpty()){
            int[] knight = queue.poll();
            if(knight[1]==goal[1] && knight[0]==goal[0]){
                count = knight[2];
                break;
            }
            for(int i=0; i<dx.length; i++){
                int fy = knight[1] + dy[i];
                int fx = knight[0] + dx[i];
                if(fy>=0 && fy<len && fx>=0 && fx<len){
                    if(knight[2]+1 < map[fy][fx]) {
                        queue.offer(new int[]{fx, fy, knight[2] + 1});
                        map[fy][fx] = knight[2]+1;
                    }
                }
            }
        }
    }
}
