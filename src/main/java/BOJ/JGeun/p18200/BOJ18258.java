package BOJ.JGeun.p18200;

import java.util.*;
import java.io.*;

public class BOJ18258 {
	static Queue<Integer> q = new LinkedList<>();
    static int last;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            getQueue(br.readLine());
        }
        System.out.println(sb);
    }
    private static void getQueue(String order) {
        StringTokenizer st = new StringTokenizer(order);
        switch(st.nextToken()) {
            case "push":
                last = Integer.parseInt(st.nextToken());
                q.offer(last);
                break;
            case "pop":
                if(q.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(q.poll()+"\n");
                break;
            case "size":
                sb.append(q.size()+"\n");
                break;
            case "empty":
                if(q.isEmpty())
                    sb.append("1\n");
                else
                    sb.append("0\n");
                break;
            case "front":
                if(q.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(q.peek()+"\n");
                break;
            case "back":
                if(q.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(last+"\n");
                break;
        }
    }
}
