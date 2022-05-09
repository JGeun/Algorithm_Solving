import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ14891 {
    private static int leftIdx = 6, rightIdx = 2, ans = 0;
    private static ArrayList<ArrayList<Integer>> wheels = new ArrayList<>();
    public static void main(String[] args) throws IOException { //맞닿는 index 2-6
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<4; i++){
            wheels.add(new ArrayList<>());
            String[] status = br.readLine().split("");
            for(String s : status) wheels.get(i).add(Integer.parseInt(s));
        }

        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int wheelIdx = Integer.parseInt(st.nextToken()); //회전시킬 톱니바퀴
            int rotDir = Integer.parseInt(st.nextToken()); //회전방향
            rotateWheels(wheelIdx-1, rotDir, new boolean[4]); //입력이 1시작이므로
        }

        for(int i=0; i<4; i++) {
            ans += wheels.get(i).get(0) == 1 ? Math.pow(2, i) : 0;
        }
        System.out.println(ans);
    }

    private static void rotateWheels(int wheelIdx, int rotDir, boolean[] visited){
        visited[wheelIdx] = true;

        if(wheelIdx != 3 && !visited[wheelIdx+1]) {
            if(wheels.get(wheelIdx).get(rightIdx) != wheels.get(wheelIdx+1).get(leftIdx)) {
                rotateWheels(wheelIdx+1, -rotDir, visited);
            }
        }

        if(wheelIdx != 0 && !visited[wheelIdx-1]) {
            if(wheels.get(wheelIdx).get(leftIdx) != wheels.get(wheelIdx-1).get(rightIdx)) {
                rotateWheels(wheelIdx-1, -rotDir, visited);
            }
        }

        int n = wheels.get(wheelIdx).remove( rotDir == 1 ? 7 : 0);
        wheels.get(wheelIdx).add(rotDir == 1 ? 0 : 7, n);
    }
}