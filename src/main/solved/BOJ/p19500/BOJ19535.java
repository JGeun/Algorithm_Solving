import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static long D=0, G = 0;
    private static long[] nodes;
    private static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nodes = new long[N+1];

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            //왼쪽이 무조건 부모인게 아님!!!!!!!!!!!!
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            nodes[parent]++;
            nodes[child]++;

            q.add(new Point(parent, child));
        }
        calG();
        calD();
        output();
    }

    public static void calG(){
        for(int i=1; i<N+1; i++){
            if(nodes[i] >= 3){
                G = G + (nodes[i] * (nodes[i] -1) * (nodes[i]-2)) / 6 ;
            }
        }
    }

    public static void calD(){
        while (!q.isEmpty()){
            Point cur = q.poll();
            D = D + (nodes[cur.x]-1) * (nodes[cur.y]-1);
        }
    }


    public static void output(){
        if(D > G*3){
            System.out.println("D");
        }
        else if (D < G*3){
            System.out.println("G");
        }
        else{
            System.out.println("DUDUDUNGA");
        }
    }
}

