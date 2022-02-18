package BOJ.p7600;

import java.io.*;
import java.util.*;

public class BOJ7662 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Data> highQueue, lowQueue;
    static HashSet<Integer> idxSet;

    private static void init() {
        highQueue = new PriorityQueue<>((Data d1, Data d2) ->
                d1.value > d2.value ? -1 : 1);
        lowQueue = new PriorityQueue<>((Data d1, Data d2) ->
                d1.value < d2.value ? -1 : 1);
        idxSet = new HashSet<>();
    }

    static void process() throws IOException {
        highQueue.clear();
        lowQueue.clear();
        idxSet.clear();

        int K = Integer.parseInt(br.readLine());
        int idx = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("I")) {
                int value = Integer.parseInt(st.nextToken());
                highQueue.add(new Data(idx, value));
                lowQueue.add(new Data(idx, value));
                idx += 1;
            } else {
                int order = Integer.parseInt(st.nextToken());
                if (order == 1) { //최댓값에서 삭제
                    while(!highQueue.isEmpty()){
                        Data data = highQueue.poll();
                        if (!idxSet.contains(data.idx)){
                            idxSet.add(data.idx);
                            break;
                        }

                    }
                } else { //최솟값에서 삭제
                    while(!lowQueue.isEmpty()){
                        Data data = lowQueue.poll();
                        if (!idxSet.contains(data.idx)) {
                            idxSet.add(data.idx);
                            break;
                        }
                    }
                }
            }
        }

        while(true){
            if(!highQueue.isEmpty() && idxSet.contains(highQueue.peek().idx)){
                highQueue.poll();
            }else if(!lowQueue.isEmpty() && idxSet.contains(lowQueue.peek().idx)){
                lowQueue.poll();
            }else{
                break;
            }
        }

        if (highQueue.isEmpty()) {
            sb.append("EMPTY").append('\n');
        } else {
            sb.append(highQueue.poll().value).append(' ').append(lowQueue.poll().value).append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            process();
        }
        System.out.print(sb);
    }


    static class Data {
        int idx, value;

        public Data(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}