import java.io.*;
import java.util.*;

public class Main {
    private static int[] piece = {1, 1, 2, 2, 2, 8};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        for (int i = 0; i < nums.length; i++) {
            int diff = piece[i] - Integer.parseInt(nums[i]);
            System.out.print(diff + " ");
        }
    }
}