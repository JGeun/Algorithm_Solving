import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer, Integer> numMap = new HashMap<>();
        numMap.put(a, numMap.getOrDefault(a, 0) + 1);
        numMap.put(b, numMap.getOrDefault(b, 0) + 1);
        numMap.put(c, numMap.getOrDefault(c, 0) + 1);
        numMap.put(d, numMap.getOrDefault(d, 0) + 1);
        
        List<Integer> keyList = new ArrayList<>(numMap.keySet());
        if (keyList.size() == 1) {
            return 1111 * keyList.get(0);
        } else if (keyList.size() == 2) {
            int p = keyList.get(0);
            int q = keyList.get(1);
            int pValue = numMap.get(p);
            int qValue = numMap.get(q);
            
            if (pValue == qValue) {
                return (p+q)*Math.abs(p-q);
            } else {
                double calc;
                if (pValue > qValue) {
                    calc = 10 * p + q;
                } else {
                    calc = 10 * q + p;
                }
                return (int)Math.pow(calc, 2.0);
            }
        } else if (keyList.size() == 3) {
            int p = keyList.get(0); int pValue = numMap.get(p);
            int q = keyList.get(1); int qValue = numMap.get(q);
            int r = keyList.get(2); int rValue = numMap.get(r);
            
            if (pValue == qValue) {
                return p * q;
            } else if (pValue == rValue){
                return p * r;
            } else {
                return q * r;
            }
        } else {
            Collections.sort(keyList);
            return keyList.get(0);
        }
    }
}