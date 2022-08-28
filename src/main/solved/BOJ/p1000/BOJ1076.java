import java.io.*;
import java.util.*;

public class Main {
    private static HashMap<String, int[]> colorMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        colorMap.put("black", new int[]{0, 1});
        colorMap.put("brown", new int[]{1, 10});
        colorMap.put("red", new int[]{2, 100});
        colorMap.put("orange", new int[]{3, 1000});
        colorMap.put("yellow", new int[]{4, 10000});
        colorMap.put("green", new int[]{5, 100000});
        colorMap.put("blue", new int[]{6, 1000000});
        colorMap.put("violet", new int[]{7, 10000000});
        colorMap.put("grey", new int[]{8, 100000000});
        colorMap.put("white", new int[]{9, 1000000000});

        int first = colorMap.get(br.readLine())[0];
        int second = colorMap.get(br.readLine())[0];
        int third = colorMap.get(br.readLine())[1];

        System.out.println((first * 10L +second)*third);
    }
}