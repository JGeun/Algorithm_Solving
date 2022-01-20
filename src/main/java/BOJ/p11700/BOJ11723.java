package BOJ.p11700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ11723 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static HashSet<Integer> set = new HashSet<>();
    static int M;

    static void input() throws IOException {
        M = Integer.parseInt(br.readLine());
    }

    static void process() throws IOException{
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("add")){
                set.add(Integer.parseInt(st.nextToken()));
            }else if(order.equals("remove")){
                set.remove(Integer.parseInt(st.nextToken()));
            }else if(order.equals("check")){
                int num = Integer.parseInt(st.nextToken());
                if(set.contains(num)) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            } else if(order.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                if(set.contains(num)) set.remove(num);
                else set.add(num);
            }else if(order.equals("all")) {
                for(int j=1; j<=20; j++) set.add(j);
            }else if(order.equals("empty")) {
                set.clear();
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
