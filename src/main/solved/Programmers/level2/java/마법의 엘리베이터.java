class Solution {
    public int solution(int storey) {

        String str = String.valueOf(storey);

        int[] storeyArr = new int[str.length()];
        for (int i=0; i<str.length(); i++) {
            storeyArr[i] = str.charAt(i) - '0';
        }

        int answer = 0, help = 0;
        for (int i = storeyArr.length-1; i>=0; i--) {
            int num = storeyArr[i] + help;

            help = 0;

            if (num > 5) {
                answer += 10 - num;

                help = 1;
            } else if (num == 5 && i > 0) {
                if (storeyArr[i-1] >= 5) {
                    answer += num;
                    help = 1;
                } else {
                    answer += num;
                }
            } else {
                answer += num;
            }
        }

        if (help > 0) answer += help;
        return answer;
    }
}