package BOJ.p23200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ23291_list {
    private static ArrayList<ArrayList<Integer>> blockList = new ArrayList<>();
    private static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        initList(blockList);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) blockList.get(N-1).add(Integer.parseInt(st.nextToken()));

        int ans = 0;
        while (!isSuccess()){
            blockProcess();
            ans += 1;
        }

        System.out.println(ans);
    }

    private static void blockProcess() {
        addOne2Min();
        rotateBlocks();
        adjustFish();
        arrangeFish();
        foldBlocks();
        adjustFish();
        arrangeFish();
    }

    private static boolean isSuccess(){
        return Collections.max(blockList.get(N-1)) - Collections.min(blockList.get(N-1)) <= K;
    }

    private static void addOne2Min() {
        int min = Collections.min(blockList.get(N-1));
        for (int i = 0; i < blockList.get(N-1).size(); i++)
            if (blockList.get(N-1).get(i) == min) blockList.get(N-1).set(i, min + 1);
    }

    private static void rotateBlocks() {
        int width = 1, height = 1;

        for(int index=0; ; index++){
            if (blockList.get(N-1).size() - width < height) break;

            for(int y =1; y<=height; y++){
                for(int x = width; x>=1; x--){
                    blockList.get(N-x-1).add(blockList.get(N-y).remove(0));
                }
            }

            if(index % 2 == 0) height+=1;
            else width+=1;
        }
    }

    private static void adjustFish() {
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i< N; i++){
            for(int j=0; j<blockList.get(i).size(); j++){
                calcDiff(queue, i, j, i, j+1);
                calcDiff(queue, i, j, i+1, j);
            }
        }

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            blockList.get(pos[0]).set(pos[1], blockList.get(pos[0]).get(pos[1])-pos[4]);
            blockList.get(pos[2]).set(pos[3], blockList.get(pos[2]).get(pos[3])+pos[4]);
        }
    }

    private static void calcDiff(Queue<int[]> queue, int n1, int p1, int n2, int p2){
        try{
            int value = Math.abs(blockList.get(n1).get(p1) - blockList.get(n2).get(p2))/5;
            if(blockList.get(n1).get(p1) > blockList.get(n2).get(p2)){
                queue.add(new int[]{n1, p1, n2, p2, value});
            }else{
                queue.add(new int[]{n2, p2, n1, p1, value});
            }
        }catch (IndexOutOfBoundsException ignored){}
    }

    private static void arrangeFish() {
        ArrayList<Integer> temp = new ArrayList<>();

        for(int i=0; i < N; i++){
            for(int j = N-1; j>=0; j--){
                if(blockList.get(j).size() != 0)
                    temp.add(blockList.get(j).remove(0));
            }
        }

        for(int t : temp) blockList.get(N-1).add(t);
    }

    private static void foldBlocks() {
        for(int i=0; i<N/2; i++)
            blockList.get(N-2).add(blockList.get(N-1).remove(0));
        Collections.reverse(blockList.get(N - 2));

        for(int i=0; i<2; i++){
            for(int j=0; j<N/4; j++){
                blockList.get(N-4+i).add(blockList.get(N-i-1).remove(0));
            }
            Collections.reverse(blockList.get(N - 4+ i));
        }
    }

    private static void initList(ArrayList<ArrayList<Integer>> list) {
        for (int i = 0; i < N; i++) list.add(new ArrayList<>());
    }
}