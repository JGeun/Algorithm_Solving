import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i=0; i<N; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, (s1, s2) -> {
            if (s1.length() != s2.length()) return s1.length() - s2.length();
            int sum1 = getNumSum(s1), sum2 = getNumSum(s2);
            if (sum1 < sum2) return -1;
            if (sum1 > sum2) return 1;
            return s1.compareTo(s2);
        });

        for (int i=0; i<N; i++) {
            System.out.println(words[i]);
        }
    }

    private static int getNumSum(String str) {
        int sum = 0;
        for (int i=0; i<str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) continue;
            sum += str.charAt(i) - '0';
        }
        return sum;
    }
}
