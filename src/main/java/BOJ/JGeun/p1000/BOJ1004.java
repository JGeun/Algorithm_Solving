package BOJ.JGeun.p1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1004 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int x1, y1, x2, y2, n;
    static Planet[] planets;
    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());
        planets = new Planet[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(x, y, r);
        }
    }

    static void process() {
        int ans = 0;
        for(int i=0; i<n; i++){
            double l1 = Math.sqrt(Math.pow(x1 - planets[i].x, 2) + Math.pow(y1 - planets[i].y, 2));
            double l2 = Math.sqrt(Math.pow(x2 - planets[i].x, 2) + Math.pow(y2 - planets[i].y, 2));
            if(planets[i].r > l1 && planets[i].r > l2) continue;
            if(planets[i].r > l1 || planets[i].r > l2) ans+=1;
        }
        sb.append(ans).append('\n');
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            input();
            process();
        }
        System.out.print(sb);
    }

    static class Planet{
        public int x, y, r;

        Planet(int _x, int _y, int _r){
            this.x = _x; this.y = _y; this.r = _r;
        }
    }
}
