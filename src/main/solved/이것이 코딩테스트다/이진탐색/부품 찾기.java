import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] item = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            item[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(item);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            System.out.print(binarySearch(item, num) + " ");
        }
    }

    private static String binarySearch(int[] item, int target) {
        int start = 0, end = item.length-1;
        while(start <= end) {
            int mid = (start+end)/2;

            if(item[mid] == target) return "yes";

            if(item[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return "no";
    }
}