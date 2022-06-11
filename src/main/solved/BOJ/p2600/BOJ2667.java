import java.util.*;

public class Main {
    private static int N, cnt;
    private static int[][] map;
    private static boolean[][] visited;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        //맵 입력
        for(int i=0; i<N; i++){
            String str = sc.nextLine();
            for(int j=0; j<str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
                visited[i][j] = false;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    cnt = 1;
                    find_house(i, j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i : list)
            System.out.println(i);

    }

    public static int find_house(int y, int x) {
        visited[y][x] = true;

        for(int i=0; i<4; i++) {
            int fx = x+dx[i];
            int fy = y+dy[i];

            if(fx>=0 && fy>=0 && fx<N && fy < N) {
                if(map[fy][fx] == 1 && !visited[fy][fx]) {
                    find_house(fy, fx);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
