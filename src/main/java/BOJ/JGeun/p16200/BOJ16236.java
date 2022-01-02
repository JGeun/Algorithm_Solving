package BOJ.JGeun.p16200;

import java.io.*;
import java.util.*;

public class BOJ16236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, eatCnt=0, ans = 0;
    static Shark baby;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] visit;
    static List<Shark> shark = new ArrayList<>();

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) baby = new Shark(i, j, 2);
                else if(map[i][j] >= 1 && map[i][j] <= 6)
                    shark.add(new Shark(i, j, map[i][j]));
            }
        }
        map[baby.x][baby.y] = 0;
        Collections.sort(shark);
    }

    static void process(){
        while(shark.size() != 0 && shark.get(0).size < baby.size){
            int dist = Integer.MAX_VALUE, index = -1;
            for(int i=0; i<shark.size(); i++){
                if(shark.get(i).size < baby.size){
                    int temp = getDistance(shark.get(i).x, shark.get(i).y, baby.x, baby.y);
                    if(temp != -1){
                        if(dist > temp){
                            dist = temp;
                            index = i;
                        }else if(dist == temp){
                            if(shark.get(i).x < shark.get(index).x ||
                                    (shark.get(i).x == shark.get(index).x
                                            && shark.get(i).y < shark.get(index).y)
                            ){
                                dist = temp;
                                index = i;
                            }
                        }
                    }
                }
            }
            if(dist == Integer.MAX_VALUE) break;
            ans += dist;
            baby.x = shark.get(index).x;
            baby.y = shark.get(index).y;
            map[baby.x][baby.y] = 0;
            shark.remove(index);
            eatCnt += 1;
            if(eatCnt == baby.size){
                baby.size+=1;
                eatCnt=0;
            }
        }
    }

    static int getDistance(int posX, int posY, int x, int y){
        Queue<Feed> q = new LinkedList<>();
        visit = new int[N][N];
        q.add(new Feed(x, y, 0));

        while(!q.isEmpty()){
            Feed feed = q.poll();

            for(int i=0; i<4; i++){
                int fx = feed.x + dx[i];
                int fy = feed.y + dy[i];
                if(fx>=0 && fx<N && fy>=0 && fy<N){
                    if(map[fx][fy] <= baby.size && (visit[fx][fy] == 0 || visit[fx][fy] > visit[feed.x][feed.y]+1)){
                        if(fx == posX && fy == posY) return feed.dist+1;
                        visit[fx][fy] = visit[feed.x][feed.y]+1;
                        q.add(new Feed(fx, fy, feed.dist+1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
        System.out.println(ans);
    }
}

abstract class Point{
    int x, y;
}

class Shark extends Point implements Comparable<Shark>{
    int size;

    public Shark(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    public int compareTo(Shark s) {
        return size - s.size;
    }
}

class Feed extends Point {
    int dist;

    public Feed(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

