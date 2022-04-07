package BOJ.p10800;

import java.util.*;
import java.lang.*;
import java.io.*;

class Member implements Comparable<Member>{
    int age;
    String name;
    int number;
    Member(int age, String name, int number){
        this.age = age;
        this.name = name;
        this.number = number;
    }
    @Override
    public int compareTo(Member m){
        if(this.age>m.age)
            return 1;
        else if(this.age<m.age)
            return -1;
        else{
            if(this.number > m.number)
                return 1;
            else if(this.number < m.number)
                return -1;
            else
                return 0;
        }
    }
}

public class BOJ10814 {
    static int N;
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Member> list = new ArrayList<Member>();
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Member(Integer.parseInt(st.nextToken()),st.nextToken(),i+1));
        }
        Collections.sort(list);
        for(int j=0; j<list.size(); j++)
            sb.append(list.get(j).age).append(" ").append(list.get(j).name).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
