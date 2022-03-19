package BOJ.p16900;

import java.io.*;
import java.util.*;

public class BOJ16956 {
    private static int R, C, result = 1;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static String[][] map;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];

        for(int i=0; i<R; i++){
            String[] line = br.readLine().split("");
            for(int j=0; j<C; j++){
                map[i][j] = line[j];
                if(line[j].equals("W")){
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        setFence();

        System.out.println(result);
        if(result == 1){
            for(int i=0; i<R; i++)
                System.out.println(String.join("", map[i]));
        }
    }

    private static void setFence(){
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int i=0; i<4; i++){
                int fx = x + dx[i];
                int fy = y + dy[i];

                if(fx>=0 && fx<R && fy>=0 && fy<C){
                    if(map[fx][fy].equals("S")){
                        result = 0;
                        return;
                    }else if(map[fx][fy].equals(".")) map[fx][fy] = "D";
                }
            }
        }
    }
}
