package BOJ.JGeun.p14700;

import java.io.*;
import java.util.*;

public class BOJ14725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static Trie trie = new Trie();

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int K = Integer.parseInt(input[0]);
            int[] arr = new int[K];
            for(int j=1; j<=K; j++){
                sb.append(input[j]);
                arr[j-1] = input[j].length();
            }

            trie.insert(sb.toString(), arr);
            sb.setLength(0);
        }
        trie.print();
    }

    static void process(){

    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }

    static class Trie{
        TrieNode rootNode;

        Trie(){ rootNode = new TrieNode(); }

        public void insert(String word, int[] arr){
            TrieNode thisNode = rootNode;

            int idx = 0;
            for(int i=0; i<arr.length; i++){
                String str = word.substring(idx, idx+arr[i]);
                idx = idx + arr[i];
                thisNode = thisNode.getChildNodes().computeIfAbsent(str, key -> new TrieNode());

            }
            thisNode.isLastChar = true;
        }

        public void print() {
            print(rootNode, 0);
        }

        public void print(TrieNode thisNode, int floor) {

            Set<String> set = thisNode.getChildNodes().keySet();
            Iterator<String> it = set.iterator();

            while (it.hasNext()) {
                String str = it.next();

                TrieNode childNode = thisNode.getChildNodes().get(str);
                for (int i = 0; i < floor; i++)
                    System.out.print("--");
                System.out.println(str);
                print(childNode, floor + 1);

            }
        }
    }

    static class TrieNode{
        Map<String, TrieNode> childNodes = new TreeMap<>();
        public boolean isLastChar;

        Map<String, TrieNode> getChildNodes(){
            return childNodes;
        }
    }
}
