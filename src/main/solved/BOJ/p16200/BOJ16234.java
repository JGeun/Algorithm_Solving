import java.util.*;
import java.io.*;

class Main {
    private static int N, L, R;
    private static int[][] A;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static List<Node> nodes;

    public static void main(String[] args) throws IOException{
        init();
        System.out.println(process());
    }

    private static int process() {
        int result = 0;
        while(true) {
            boolean isMove = false;
            visited = new boolean[N][N];

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (!visited[i][j]) {
                        int sum = checkNode(i, j);
                        if (nodes.size() > 1) {
                            changePopulation(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove) return result;
            result += 1;
        }
    }

    private static int checkNode(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        nodes = new ArrayList<>();

        q.offer(new Node(r, c));
        nodes.add(new Node(r, c));
        visited[r][c] = true;

        int sum = A[r][c];
        while(!q.isEmpty()) {
            Node curNode = q.poll();

            for (int i=0; i<4; i++) {
                int fx = curNode.x + dx[i];
                int fy = curNode.y + dy[i];

                if (fx >=0 && fy >=0 && fx < N && fy < N && !visited[fx][fy]) {
                    int diff = Math.abs(A[curNode.x][curNode.y] - A[fx][fy]);
                    if (L <= diff && diff <= R) {
                        q.offer(new Node(fx, fy));
                        nodes.add(new Node(fx, fy));
                        sum += A[fx][fy];
                        visited[fx][fy] = true;
                    }
                }
            }
        }
        return sum;
    }

    private static void changePopulation(int sum) {
        for (Node node : nodes) {
            A[node.x][node.y] = sum/nodes.size();
        }
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x; this.y = y;
        }
    }


    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }
    }
}