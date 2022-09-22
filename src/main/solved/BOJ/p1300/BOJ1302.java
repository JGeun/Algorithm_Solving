import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> bestSellers = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String book = br.readLine();
            if (bestSellers.containsKey(book)) {
                bestSellers.put(book, bestSellers.get(book)+1);
            } else {
                bestSellers.put(book, 1);
            }
        }

        List<String> bookList = new ArrayList(bestSellers.keySet());
        Collections.sort(bookList);
        int maxCnt = 0;
        String ans = "";
        for (String book : bookList) {
            if (maxCnt < bestSellers.get(book)) {
                maxCnt = bestSellers.get(book);
                ans = book;
            }
        }
        System.out.println(ans);
    }
}