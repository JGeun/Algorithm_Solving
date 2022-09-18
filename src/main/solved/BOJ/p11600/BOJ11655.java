import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (char s : str.toCharArray()) {
            char ch = s;
            if (s>='a' && s <= 'z') {
                ch = (char) ((s-'a'+13)%26+'a');
            } else if (s >='A' && s <= 'Z') {
                ch = (char) ((s-'A'+13)%26+'A');
            }
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}