import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class BOJ1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] time = new int[N][2];

        for(int i=0; i<N; i++) {
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[1] == arr2[1])
                    return Integer.compare(arr1[0], arr2[0]);
                else
                    return Integer.compare(arr1[1], arr2[1]);
            }
        });

        int end=-1;
        int count =0;

        for(int i=0; i<N; i++) {
            if(time[i][0] >= end) {
                end = time[i][1];
                count+=1;
            }
        }
        System.out.println(count);
    }
}