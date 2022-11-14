import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> nodes = new ArrayList();
    private static int[] depth, childCnt;
    private static int maxDepth = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        depth = new int[N+1];
        childCnt = new int[N+1];
        Arrays.fill(depth, 1000000);
        Arrays.fill(childCnt, 1);

        for (int i=0; i<=N; i++) {
            nodes.add(new ArrayList());
        }

        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }

        checkDepth(R);
        checkChildCnt(R);

        for (int i=0; i<Q; i++) {
            int pos = Integer.parseInt(br.readLine());
            sb.append(childCnt[pos]).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static int checkChildCnt(int R) {

        int cnt = 0;
        ArrayList<Integer> child = nodes.get(R);

        for (int i=0; i<child.size(); i++) {
            if (depth[child.get(i)] < depth[R]) continue;
            cnt += checkChildCnt(child.get(i));
        }

        childCnt[R] = cnt+1;
        return childCnt[R];
    }

    private static void fillChildCnt(int pos) {
        ArrayList<Integer> parent = nodes.get(pos);

        for (int i=0; i<parent.size(); i++) {
            int parentPos = parent.get(i);
            if (depth[parentPos] > depth[pos]) continue;
            childCnt[parentPos] += childCnt[pos];
            fillChildCnt(parentPos);
        }
    }

    private static void checkDepth(int root) {
        Queue<Integer> nodeQueue = new LinkedList<>();
        depth[root] = 1;
        nodeQueue.offer(root);

        while(!nodeQueue.isEmpty()) {
            int parent = nodeQueue.poll();
            ArrayList<Integer> child = nodes.get(parent);

            for (int i=0; i<child.size(); i++) {
                if (depth[child.get(i)] < depth[parent]) continue;
                depth[child.get(i)] = depth[parent]+1;
                maxDepth = Math.max(maxDepth, depth[parent]+1);
                nodeQueue.offer(child.get(i));
            }
        }
    }
}