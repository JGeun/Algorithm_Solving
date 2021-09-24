package BOJ.JGeun.p1600;

import java.io.*;
import java.util.*;

public class BOJ1655 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static PriorityQueue<Integer> maxQueue, minQueue;


    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        maxQueue = new PriorityQueue<>();
        minQueue = new PriorityQueue<>(Collections.reverseOrder());
    }

    static void process() throws IOException{
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(maxQueue.isEmpty()) maxQueue.add(num);
            else if(minQueue.isEmpty()){
                if(maxQueue.peek() < num){
                    maxQueue.add(num);
                    minQueue.add(maxQueue.poll());
                }else{
                    minQueue.add(num);
                }
            }else{
                if(maxQueue.peek() < num) maxQueue.add(num);
                else minQueue.add(num);

                if(minQueue.size()+2 == maxQueue.size()){
                    minQueue.add(maxQueue.poll());
                }else if(maxQueue.size()+2 == minQueue.size()) {
                    maxQueue.add(minQueue.poll());
                }
            }
            if(maxQueue.size() > minQueue.size()) sb.append(maxQueue.peek()).append('\n');
            else sb.append(minQueue.peek()).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
