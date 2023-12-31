import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long X = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        while (N-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sum += (long) a * b;
        }

        System.out.println(sum == X ? "Yes" : "No");
    }
}