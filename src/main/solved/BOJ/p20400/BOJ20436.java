import java.io.*;
import java.util.*;

// 이 문제는 자음 모음을 분리하여 저장하고 꺼내면 되는 문제입니다.
// 알파벳별로 자음인지 모음인지 저장하고, 알파벳의 위치 역시 저장해야 합니다.
class Main {
    private static HashSet<Character> vowelSet = new HashSet<>();
    private static HashMap<Character, int[]> alphaMap = new HashMap<>();

    private static char sl, sr;
    private static int[] slPos, srPos;

    private static String str;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int res = str.length();

        for (int i=0; i<str.length(); i++) {
            char ch =str.charAt(i);

            int[] nextPos = alphaMap.get(ch);
            if (vowelSet.contains(ch)) {
                res += Math.abs(srPos[0]-nextPos[0]) + Math.abs(srPos[1]-nextPos[1]);
                srPos = nextPos;
            } else {
                res += Math.abs(slPos[0]-nextPos[0]) + Math.abs(slPos[1]-nextPos[1]);
                slPos = nextPos;
            }
        }

        System.out.println(res);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();
        sl = inputLine.charAt(0);
        sr = inputLine.charAt(2);


        // 한글 모음인거 저장하기
        vowelSet.add('y');
        vowelSet.add('u');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('p');
        vowelSet.add('h');
        vowelSet.add('j');
        vowelSet.add('k');
        vowelSet.add('l');
        vowelSet.add('b');
        vowelSet.add('n');
        vowelSet.add('m');

        // 알파벳 위치 저장하기
        alphaMap.put('q', new int[]{1, 1});
        alphaMap.put('w', new int[]{1, 2});
        alphaMap.put('e', new int[]{1, 3});
        alphaMap.put('r', new int[]{1, 4});
        alphaMap.put('t', new int[]{1, 5});
        alphaMap.put('y', new int[]{1, 6});
        alphaMap.put('u', new int[]{1, 7});
        alphaMap.put('i', new int[]{1, 8});
        alphaMap.put('o', new int[]{1, 9});
        alphaMap.put('p', new int[]{1, 10});
        alphaMap.put('a', new int[]{2, 1});
        alphaMap.put('s', new int[]{2, 2});
        alphaMap.put('d', new int[]{2, 3});
        alphaMap.put('f', new int[]{2, 4});
        alphaMap.put('g', new int[]{2, 5});
        alphaMap.put('h', new int[]{2, 6});
        alphaMap.put('j', new int[]{2, 7});
        alphaMap.put('k', new int[]{2, 8});
        alphaMap.put('l', new int[]{2, 9});
        alphaMap.put('z', new int[]{3, 1});
        alphaMap.put('x', new int[]{3, 2});
        alphaMap.put('c', new int[]{3, 3});
        alphaMap.put('v', new int[]{3, 4});
        alphaMap.put('b', new int[]{3, 5});
        alphaMap.put('n', new int[]{3, 6});
        alphaMap.put('m', new int[]{3, 7});

        slPos = alphaMap.get(sl);
        srPos = alphaMap.get(sr);

        str = br.readLine();
    }


}