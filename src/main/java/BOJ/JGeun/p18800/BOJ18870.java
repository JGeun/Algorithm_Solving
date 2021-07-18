package BOJ.JGeun.p18800;

import java.util.*;
import java.io.*;

public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        ArrayList<Integer> numArrayList = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            numArr[i] = Integer.parseInt(input[i]);;
            if(!numArrayList.contains(numArr[i]))
                numArrayList.add(numArr[i]);
        }

        Collections.sort(numArrayList);
        for(int i=0; i<N; i++){
            System.out.print(numArrayList.indexOf(numArr[i])+" ");
        }
    }
}