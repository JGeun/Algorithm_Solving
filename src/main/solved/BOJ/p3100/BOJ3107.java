package BOJ.p3100;

import java.io.*;
import java.util.*;

public class BOJ3107 {
    private static String address;
    private static final int SIZE = 8;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        address = br.readLine().replace("::", ":A:");
        String[] fullAddress = new String[SIZE];
        Arrays.fill(fullAddress, "");
        String[] ipBlock = address.split(":");

        int index = 0;
        while(index < ipBlock.length && !ipBlock[index].equals("A"))
            fullAddress[index] = ipBlock[index++];

        index = 0;
        while(index < ipBlock.length && !ipBlock[ipBlock.length-1-index].equals("A")){
            fullAddress[SIZE-1-index] = ipBlock[ipBlock.length-1-index];
            index+=1;
        }

        for(int i=0; i<SIZE; i++){
            while(fullAddress[i].length() < 4) fullAddress[i] = "0" + fullAddress[i];
        }


        System.out.println(String.join(":", fullAddress));
    }
}
