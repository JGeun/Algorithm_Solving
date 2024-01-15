import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] person = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(person);
        System.out.println(person[person.length-k]);
    }
}