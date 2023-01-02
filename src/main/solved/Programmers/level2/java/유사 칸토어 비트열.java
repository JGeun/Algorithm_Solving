// 첫 번째 접근: 1~n까지 계속 치환해서 문자열을 만들고 l부터 r범위까지 카운팅하는 방법.
// 두 번째 접근: l, r이 long범위까지 갈 수 있기 떄문에 재귀로 범위를 줄여가면서 가장 낮은 1~5범위까지 맞춘 다음 카운팅하는 방법
class Solution {
    public int solution(int n, long l, long r) {
        return countBit(r) - countBit(l-1);
    }

    private int countBit(long num) {
        if (num <= 5) {
            return countChar("11011".substring(0, (int)num), '1');
        }

        int base = 1;
        while((long)Math.pow(5, (base+1)) < num) {
            base += 1;
        }

        long value = (long)Math.pow(5, base);
        int section = (int)(num / value);
        int remainder = (int)(num % value);

        int answer = section * (int)Math.pow(4, base);

        if (section >= 3) {
            answer -= Math.pow(4, base);
        }

        if (section == 2) {
            return answer;
        } else {
            return answer + countBit(remainder);
        }
    }

    private int countChar(String str, char ch) {
        int count = 0;

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == ch) {
                count += 1;
            }
        }

        return count;
    }
}

// 0 -> 1
// 1 -> 11011
// 2 -> 11011 11011 00000 11011 11011
// 3 -> 11011 11011 00000 11011 11011 11011 11011 00000 11011 11011 00000 00000 00000 00000 00000 11011 11011 00000 11011 11011 11011 11011 00000 11011 11011