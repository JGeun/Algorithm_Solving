import java.util.*;

class Solution {
    private Set<String> availableWordSet = new HashSet<>();
    private String[] words = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;

        makeWords(0, "", new boolean[4]);

        for (String word : babbling) {
            if (availableWordSet.contains(word)) {
                answer += 1;
            }
        }
        return answer;
    }

    private void makeWords(int start, String word, boolean[] visited) {
        if (start == 4) {
            availableWordSet.add(word);
            return ;
        }

        for (int i=0; i<4; i++) {
            if (!visited[i]) {
                visited[i] = true;
                availableWordSet.add(word);
                makeWords(start+1, word+words[i], visited);
                visited[i] = false;
            }
        }
    }
}