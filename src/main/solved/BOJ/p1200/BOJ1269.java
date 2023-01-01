import java.io.*;
import java.util.*;

// A와 B를 각각의 해쉬맵에 저장해주고 A와 B의 공통된 데이터를 지워준 후 각각의 key값에 대한 value를 더해주면 된다.
public class Main {

    private static HashMap<Integer, Integer> mapA = new HashMap<>();
    private static HashMap<Integer, Integer> mapB = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        List<Integer> mapAKeyList = new ArrayList<>(mapA.keySet());
        for (int key : mapAKeyList) {
            if (mapB.containsKey(key)) {
                mapA.remove(key);
                mapB.remove(key);
            }
        }

        int ans = 0;

        for (Integer key : mapA.keySet()) {
            ans += mapA.get(key);
        }

        for (Integer key : mapB.keySet()) {
            ans += mapB.get(key);
        }

        System.out.println(ans);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            int key = Integer.parseInt(st.nextToken());
            mapA.put(key, mapA.getOrDefault(key, 0) + 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            int key = Integer.parseInt(st.nextToken());
            mapB.put(key, mapB.getOrDefault(key, 0) + 1);
        }
    }
}