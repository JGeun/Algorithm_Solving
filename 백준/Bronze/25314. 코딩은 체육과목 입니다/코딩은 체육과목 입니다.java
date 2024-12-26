import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        sb.append("long ".repeat(Math.max(0, N / 4)));
        sb.append("int");
        System.out.println(sb);
    }
}