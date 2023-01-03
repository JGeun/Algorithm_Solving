import java.io.*;
import java.util.*;

// 상근이의 숫자 카드를 hashset에 저장하고 넷째 줄에 들어오는 숫자들을 hashset이 포함하고 있으면 1 없으면 0을 입력한다.
public class Main {

    private static HashSet<Integer> cardSet = new HashSet<>();
    private static int N, M;
    private static int[] numCards;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<M; i++) {
            sb.append(cardSet.contains(numCards[i]) ? 1 : 0).append(' ');
        }

        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            cardSet.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        numCards = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            numCards[i] = Integer.parseInt(st.nextToken());
        }

    }
}