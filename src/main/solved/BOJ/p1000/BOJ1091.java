import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] p = new int[N];
        int[] next = new int[N];
        int[] s = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            next[i] = p[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        while(true) {
            if (validationCard(next)) {
                break;
            }
            shuffle(next, s);
            ans += 1;

            if (isSameOriginal(p, next)) {
                ans = -1;
                break;
            }
        }

        System.out.println(ans);
    }

    private static void shuffle(int[] next, int[] s) {
        int[] temp = next.clone();
        for (int i=0; i<next.length; i++) {
            temp[s[i]] = next[i];
        }

        for(int i=0; i<next.length; i++) {
            next[i] = temp[i];
        }
    }

    private static boolean validationCard(int[] next) {
        for (int i=0; i<next.length; i++) {
            if (next[i] != i%3) return false;
        }
        return true;
    }

    private static boolean isSameOriginal(int[] p, int[] next) {
        for (int i=0; i<next.length; i++) {
            if (p[i] != next[i]) {
                return false;
            }
        }
        return true;
    }
}