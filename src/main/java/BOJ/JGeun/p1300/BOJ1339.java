package BOJ.JGeun.p1300;

import java.io.*;
import java.util.*;

public class BOJ1339 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static String[] words;
    static HashMap<Character, Integer> map = new HashMap<>();
    static int[] alpha;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        alpha = new int[26];
        words = new String[N];
        for(int i=0; i<N; i++) words[i] = br.readLine();
    }

    static void process() {
        int ans = 0;

        for(int i=0; i<N; i++){
            int pos = 1;
            for(int j=words[i].length()-1; j>=0; j--){
                char ch = words[i].charAt(j);
                if(map.containsKey(ch)) map.put(ch, map.get(ch)+pos);
                else map.put(ch, pos);
                pos*=10;
            }
        }
        ArrayList<Character> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        int num = 9;
        for(int i=0; i<keyList.size(); i++){
            ans += num*map.get(keyList.get(i));
            num-=1;
        }
        System.out.println(ans);
    }


    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
