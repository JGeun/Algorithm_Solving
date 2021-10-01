package BOJ.JGeun.p2200;

import java.io.*;
import java.util.*;

public class BOJ2250 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, point = 1, maxLevel = 0;
    static int[] levelMin, levelMax, parent;
    static Node[] tree;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        levelMin = new int[N+1];
        levelMax = new int[N+1];
        tree = new Node[N+1];
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            tree[i] = new Node(-1, -1);
            levelMin[i] = N;
            parent[i] = -1;
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree[idx].left = left; tree[idx].right = right;
            if(left != -1) parent[left] = idx;
            if(right != -1) parent[right] = idx;
        }
    }

    static void process(){
        inorder(getRoot(), 1);

        int ansLevel = 1, ansWidth = levelMax[1] - levelMin[1] + 1;
        for(int i=2; i<= maxLevel; i++){
            int width = levelMax[i] - levelMin[i] + 1;
            if(ansWidth < width){
                ansWidth = width;
                ansLevel = i;
            }
        }
        System.out.println(ansLevel + " " + ansWidth);
    }

    static int getRoot(){
        for(int i=1; i<=N; i++){
            if(parent[i] == -1)
                return i;
        }
        return N;
    }

    static void inorder(int idx, int level){
        Node root = tree[idx];
        if(maxLevel < level) maxLevel = level;
        if(root.left != -1) inorder(root.left, level+1);
        levelMin[level] = Math.min(levelMin[level], point);
        levelMax[level] = point;
        point++;
        if(root.right != -1) inorder(root.right, level+1);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static class Node{
        int left, right;

        Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
}
