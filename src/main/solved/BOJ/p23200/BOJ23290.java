package BOJ.p23200;

import java.io.*;
import java.util.*;

public class BOJ23290 {
    private static int start=1, end=4, M, S;

    private static LinkedList<Fish>[][] map = new LinkedList[5][5];
    private static LinkedList<Fish>[][] temp = new LinkedList[5][5];
    private static HashMap<Integer, LinkedList<Fish>> store = new HashMap<>();
    private static int[] fDx = {0, 0, -1, -1, -1, 0, 1, 1, 1}; //물고기 상하
    private static int[] fDy = {0, -1, -1, 0, 1, 1, 1, 0, -1}; //물고기 좌우

    private static Fish shark;
    private static int removedFishCnt = -1;
    private static int[] sharkMove = new int[3];
    private static int[] sDx = {-1, 0, 1, 0}; //상어 상하
    private static int[] sDy = {0, -1, 0, 1}; //상어 좌우
    private static int[][] smellMap = new int[5][5];

    public static void main(String[] args) throws IOException{
        input();
        while(S-->0){
            process();
        }

        System.out.println(getRestFishCnt());
    }

    private static void process(){
        copyFish();
        moveFish();
        moveShark();
        removeSmell();
        restoreFish();
    }

    private static void copyFish(){
        for(int i=start; i<=end; i++){
            for(int j=start; j<=end; j++){
                if(map[i][j].size() != 0)
                    store.put(i*10+j, (LinkedList<Fish>)map[i][j].clone());
            }
        }
    }

    private static void moveFish(){
        for(int i=start; i<=end; i++) {
            for (int j = start; j <= end; j++) {
                while(map[i][j].size() != 0)
                    move(map[i][j].remove(0));
            }
        }
    }

    private static void move(Fish fish) {
        int fd = fish.d;
        do{
            int fx = fish.x + fDx[fd];
            int fy = fish.y + fDy[fd];

            if(fx >= start && fx <= end && fy >= start && fy <= end){
                if(smellMap[fx][fy] == 0 && !isOverlapWithShark(fx, fy)){
                    temp[fx][fy].add(new Fish(fx, fy, fd));
                    return;
                }
            }
            fd = changeDir(fd);
        }while(fd != fish.d);

        temp[fish.x][fish.y].add(new Fish(fish.x, fish.y, fish.d));
    }

    private static boolean isOverlapWithShark(int x, int y){
        return shark.x == x && shark.y == y;
    }

    private static int changeDir(int fd) {
        return fd - 1 == 0 ? 8 : fd - 1;
    }

    private static void moveShark(){
        removedFishCnt = -1;
        findBestSharkRoute(shark.x, shark.y, new int[3], new boolean[5][5], 0, 0);

        for(int i=0; i<3; i++){
            shark.x += sDx[sharkMove[i]];
            shark.y += sDy[sharkMove[i]];

            if(temp[shark.x][shark.y].size() != 0){
                smellMap[shark.x][shark.y] = S;
                temp[shark.x][shark.y].clear();
            }
        }
    }

    private static void findBestSharkRoute(int x, int y, int[] move, boolean[][] isEat, int cnt, int sum){
        if(cnt == 3){
            if(removedFishCnt < sum){
                removedFishCnt = sum;
                for(int i=0; i<3; i++) sharkMove[i] = move[i];
            }
            return;
        }

        for(int i=0; i<4; i++){
            int fx = x + sDx[i];
            int fy = y + sDy[i];

            if(fx >= start && fx <= end && fy >= start && fy <= end){
                move[cnt] = i;
                if(!isEat[fx][fy]){
                    isEat[fx][fy] = true;
                    findBestSharkRoute(fx, fy, move, isEat, cnt+1,sum+temp[fx][fy].size());
                    isEat[fx][fy] = false;
                }else{
                    findBestSharkRoute(fx, fy, move, isEat, cnt+1,sum);
                }
            }
        }
    }

    private static void removeSmell(){
        for(int i=start; i<=end; i++) {
            for (int j = start; j <= end; j++) {
                if(smellMap[i][j] != 0 && smellMap[i][j] >= S+2) smellMap[i][j] = 0;
            }
        }
    }

    private static void restoreFish(){
        for(int i=start; i<=end; i++) {
            for (int j = start; j <= end; j++) {
                while(temp[i][j].size() != 0) map[i][j].add(temp[i][j].remove(0));
                if(store.containsKey(i*10+j)) for(Fish f : store.get(i*10+j)) map[i][j].add(f);
            }
        }
        store.clear();
    }

    private static int getRestFishCnt(){
        int sum = 0;
        for(int i=start; i<=end; i++) {
            for (int j = start; j <= end; j++) {
                sum += map[i][j].size();
            }
        }
        return sum;
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=start; i<=end; i++){
            for(int j=start; j<=end; j++){
                map[i][j] = new LinkedList<>();
                temp[i][j] = new LinkedList<>();
            }
        }

        M = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[x][y].add(new Fish(x, y, d));
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        shark = new Fish(x, y, -1);
    }

    static class Fish{
        int x, y, d; //x, y 위치, d: 방향

        public Fish(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
