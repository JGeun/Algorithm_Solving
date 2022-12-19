import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        while(true) {
            if (isPrime(num) && isPalindrome(String.valueOf(num))) {
                System.out.println(num);
                break;
            }
            num += 1;
        }
    }

    private static boolean isPalindrome(String num) {
        for (int i=0; i<=num.length()/2; i++) {
            if (num.charAt(i) != num.charAt(num.length()-i-1)) return false;
        }
        return true;
    }

    private static boolean isPrime(int num) {
        if(num == 1) return false;
        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}