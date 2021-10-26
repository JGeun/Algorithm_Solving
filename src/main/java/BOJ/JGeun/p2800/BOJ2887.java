package BOJ.JGeun.p2800;

import java.io.*;
import java.util.*;

public class BOJ2887 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder("");
    static StringTokenizer st;

    static int N;
    static Point[] points;
    static int[] parent;
    static PriorityQueue<Edge> edgeList = new PriorityQueue<>();

    static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        points = new Point[N];
        parent = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            points[i] = new Point(i, x, y, z);
        }
    }

    static void process(){
        Arrays.sort(points, Comparator.comparingInt(p -> p.x));
        for(int i=0; i<N-1; i++){
            int weight = Math.abs(points[i].x - points[i+1].x);
            edgeList.add(new Edge(points[i].idx, points[i+1].idx, weight));
        }

        Arrays.sort(points, Comparator.comparingInt(p -> p.y));
        for(int i=0; i<N-1; i++){
            int weight = Math.abs(points[i].y - points[i+1].y);
            edgeList.add(new Edge(points[i].idx, points[i+1].idx, weight));
        }

        Arrays.sort(points, Comparator.comparingInt(p -> p.z));
        for(int i=0; i<N-1; i++){
            int weight = Math.abs(points[i].z - points[i+1].z);
            edgeList.add(new Edge(points[i].idx, points[i+1].idx, weight));
        }

        Arrays.fill(parent, -1);

        int ans = 0;
        while(!edgeList.isEmpty()){
            Edge edge = edgeList.poll();
            if(find(edge.start) != find(edge.end)){
                ans += edge.weight;
                union(edge.start, edge.end);
            }
        }
        System.out.println(ans);
    }

    static int find(int edge){
        if(parent[edge] == -1){
            return edge;
        }
        return parent[edge] = find(parent[edge]);
    }

    static void union(int start, int end){
        start = find(start);
        end = find(end);

        if(start != end){
            parent[end] = start;
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }

    static class Point{
        int idx, x, y, z;

        Point(int idx, int x, int y, int z){
            this.idx = idx; this.x = x; this.y = y; this.z = z;
        }
    }

    static class Edge implements Comparable<Edge>{
        int start, end, weight;
        Edge(int start, int end, int weight){
            this.start = start; this.end = end; this.weight =weight;
        }

        @Override
        public int compareTo(Edge e){
            return weight - e.weight;
        }
    }
}
