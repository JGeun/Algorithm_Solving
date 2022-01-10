package BOJ.JGeun.p17200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ17219 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, M;
    static HashMap<String ,String> pagePw;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pagePw = new HashMap<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            pagePw.put(st.nextToken(), st.nextToken());
        }
    }

    static void process() throws IOException{
        for (int i = 0; i < M; i++)
            sb.append(pagePw.get(br.readLine())).append('\n');
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
