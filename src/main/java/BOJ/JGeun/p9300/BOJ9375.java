package BOJ.JGeun.p9300;

import java.util.*;

public class BOJ9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<>();
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            hashMap.clear();

            int n = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < n; j++) {
                String[] wear = sc.nextLine().split(" ");
                if (!hashMap.containsKey(wear[1])) {
                    hashMap.put(wear[1], 1);
                } else {
                    int value = hashMap.get(wear[1]);
                    hashMap.remove(wear[1]);
                    hashMap.put(wear[1], value + 1);
                }
            }

            int caseValue = 1;
            for (Map.Entry<String, Integer> map : hashMap.entrySet()) {
                caseValue *= (map.getValue()+1);
            }
            System.out.println(caseValue-1);
        }
    }
}
