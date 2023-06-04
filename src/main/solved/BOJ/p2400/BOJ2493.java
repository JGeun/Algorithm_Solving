import java.io.*;
import java.util.*;

class Main {

    private static int N;
    private static Stack<Tower> towerStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (towerStack.isEmpty()) {
                sb.append(0).append(" ");
                towerStack.push(new Tower(i, height));
                continue;
            }

            boolean isFindTower = false;
            while (!towerStack.isEmpty()) {
                Tower tower = towerStack.peek();

                if (tower.height <= height) {
                    towerStack.pop();
                    continue;
                }

                sb.append(tower.idx).append(" ");
                towerStack.push(new Tower(i, height));
                isFindTower = true;
                break;
            }

            if (!isFindTower) {
                sb.append(0).append(" ");
                towerStack.push(new Tower(i, height));
            }
        }

        System.out.println(sb.toString());
    }

    private static class Tower {
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}