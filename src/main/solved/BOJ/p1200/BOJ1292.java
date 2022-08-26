import java.io.*;
import java.util.*;

public class Main {
    private static int A, B;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int cnt = 1, sum = 0, idx = 1, idxCnt = 0;
        while (cnt <= B) {
            if (cnt >= A) {
                sum += idx;
            }
            idxCnt += 1;
            if (idx == idxCnt) {
                idx += 1;
                idxCnt = 0;
            }
            cnt += 1;
        }
        System.out.println(sum);
    }
}
