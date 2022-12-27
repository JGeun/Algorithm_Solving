import java.io.*;
import java.util.*;

public class Main {

    private static int N;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        List<Person> persons = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            persons.add(new Person(i));
        }

        int round = 1, idx = 0;
        while(persons.size() != 1) {
            int removedIdx = (int)(((long)Math.pow(round, 3)+idx) % persons.size());
            if (removedIdx == 0) removedIdx = persons.size();
            persons.remove(removedIdx-1);
            idx = removedIdx-1;
            round += 1;
        }

        System.out.println(persons.get(0).idx);
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    private static class Person {
        private int idx;

        public Person(int idx) {
            this.idx = idx;
        }
    }
}