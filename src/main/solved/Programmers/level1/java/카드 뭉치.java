import java.util.*;

class Solution {

    public String solution(String[] card1, String[] card2, String[] goal) {
        String answer = "";

        int c1Idx=0, c2Idx=0, gIdx = 0;
        while (card1.length != c1Idx && card2.length != c2Idx && gIdx != goal.length) {
            if(card1[c1Idx].equals(goal[gIdx])) {
                gIdx += 1;
                c1Idx += 1;
                continue;
            } else if(card2[c2Idx].equals(goal[gIdx])) {
                gIdx += 1;
                c2Idx += 1;
                continue;
            }

            return "No";
        }

        while(c1Idx != card1.length && gIdx != goal.length) {
            if (!card1[c1Idx].equals(goal[gIdx])) break;
            c1Idx += 1;
            gIdx += 1;
        }

        while(c2Idx != card2.length && gIdx != goal.length) {
            if (!card2[c2Idx].equals(goal[gIdx])) break;
            c2Idx += 1;
            gIdx += 1;
        }

        if (gIdx == goal.length) return "Yes";
        return "No";
    }
}