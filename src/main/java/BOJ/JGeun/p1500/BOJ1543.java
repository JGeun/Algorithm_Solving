package BOJ.JGeun.p1500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1543 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String str, words;

    public static void main(String[] args) throws IOException {
        str = br.readLine(); words = br.readLine();

        int ans =0;
        while(str.contains(words)){
            ans += 1;
            str = str.substring(str.indexOf(words)+words.length());
        }

        System.out.println(ans);
    }
}

