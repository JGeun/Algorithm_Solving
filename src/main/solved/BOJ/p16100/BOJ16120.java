import java.io.*;

// 시간복잡도 O(N)의 해결법
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder("");

        for(int i=0; i<str.length(); i++) {
            sb.append(str.charAt(i));

            while (sb.length() >= 4) {
                if (sb.substring(sb.length()-4, sb.length()).equals("PPAP")) {
                    sb.delete(sb.length()-4, sb.length());
                    sb.append('P');
                } else {
                    break;
                }
            }
        }

        System.out.println(sb.toString().equals("P") ? "PPAP" : "NP");
    }
}

// 시간복잡도 O(N^2)인 케이스
import java.io.*;

public class Diff {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        long start = System.nanoTime();

        while(str.contains("PPAP")) {
            str = str.replaceAll("PPAP", "P");
        }

        long end = System.nanoTime();
        long diff = (end-start);
        System.out.println("time: " + diff);
        System.out.println(str.equals("P") ? "PPAP" : "NP");
    }
}
