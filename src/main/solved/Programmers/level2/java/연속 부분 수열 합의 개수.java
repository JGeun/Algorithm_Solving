import java.util.*;

class Solution {
    private HashSet<Integer> elementSet = new HashSet();
    public int solution(int[] elements) {

        for (int i=1; i<=elements.length; i++) {
            for (int j=0; j<elements.length; j++) {
                int sum = 0;
                for (int k=j; k<j+i; k++) {
                    sum += elements[k%elements.length];
                }
                elementSet.add(sum);
            }
        }

        return elementSet.size();
    }
}