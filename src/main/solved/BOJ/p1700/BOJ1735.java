import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1]);

        nums = br.readLine().split(" ");
        int c = Integer.parseInt(nums[0]);
        int d= Integer.parseInt(nums[1]);

        int x = a*d + b * c;
        int y = b * d;

        StringBuilder sb = new StringBuilder();
        int gcd = getGcd(x, y);
        sb.append(x/gcd).append(' ').append(y/gcd);
        System.out.println(sb);
    }

    public static int getGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGcd(b, a % b);
    }
}