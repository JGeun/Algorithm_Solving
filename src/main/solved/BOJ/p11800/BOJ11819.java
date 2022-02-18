package BOJ.p11800;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ11819 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static BigInteger A, B, C;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = new BigInteger(st.nextToken());
        B = new BigInteger(st.nextToken());
        C = new BigInteger(st.nextToken());
    }

    static BigInteger process(BigInteger A, BigInteger B, BigInteger C) {
        if(B.equals(BigInteger.ZERO)) return BigInteger.ONE;
        else if(B.equals(BigInteger.ONE)) return A;
        else{
            BigInteger value = process(A, B.divide(BigInteger.TWO), C);
            if(B.remainder(BigInteger.TWO).equals(BigInteger.ZERO)) return calc(value, value);
            else return calc(calc(value, value),A);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(process(A.mod(C), B, C));
    }

    public static BigInteger calc(BigInteger n1, BigInteger n2){
        return n1.multiply(n2).mod(C);
    }
}
