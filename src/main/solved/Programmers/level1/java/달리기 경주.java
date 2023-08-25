import java.util.*;

class Solution {
    private HashMap<String, Integer> playerMap = new HashMap<>();

    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        for (int i=0; i<players.length; i++) {
            answer[i] = players[i];
            playerMap.put(players[i], i);
        }

        for (String calling : callings) {
            int callingIndx = playerMap.get(calling);

            // 조건에서 불리지 않는다고 했지만 일단 패스
            if (callingIndx == 0) continue;

            String prevPlayer = answer[callingIndx-1];
            playerMap.put(prevPlayer, callingIndx);
            playerMap.put(calling, callingIndx-1);

            answer[callingIndx] = prevPlayer;
            answer[callingIndx-1] = calling;
        }

        return answer;
    }
}