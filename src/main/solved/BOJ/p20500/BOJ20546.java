import java.io.*;
import java.util.*;

class Main {
    private static int N, A, B, aStock,bStock;
    private static int[] days;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {

        int graph = 0; // 오르락 내리락 하는 지표
        for (int i=0; i<days.length; i++) {
            if (A >= days[i]) {
                int aCnt = A/days[i];
                aStock += aCnt;
                A -= aCnt * days[i];
            }

            if (i == 0) continue;

            if (graph >= 0 && days[i] > days[i-1]) graph += 1;
            else if (graph <= 0 && days[i] > days[i-1]) graph = 1;
            else if (graph <= 0 && days[i] < days[i-1]) graph -= 1;
            else if (graph >= 0 && days[i] < days[i-1]) graph = -1;
            else graph = 0;

            if (graph >= 3) {
                B += bStock * days[i];
                bStock = 0;
            } else if (graph <= -3) {
                int bCnt = B/days[i];
                bStock += bCnt;
                B -= bCnt * days[i];
            }
        }

        int resA = aStock*days[days.length-1]+A;
        int resB = bStock*days[days.length-1]+B;

        if (resA > resB) {
            System.out.println("BNP");
        } else if (resA < resB) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = N; B = N;

        days = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<14; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }
        aStock = 0;
        bStock = 0;
    }
}