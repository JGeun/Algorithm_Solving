package Programmers.Kakao_Intership_2021;

import java.util.*;

class Solution {
    private int root, size;
    private Node[] tree;
    private int[] parent;

    public int solution(int k, int[] num, int[][] links) {
        int answer = 0;
        setTree(num, links);

        int low = 0, high = (int)1e9;
        //high의 경우 Integer.MAX_VALUE를 하면 원소 중 최댓값을 더해줬을 때
        //int범위를 벗어남으로 주의해줘야합니다.
        for(int n : num) low = Math.max(low, n);

        while(low <= high){
            int mid = (low+high)/2;
            if(checkGroup(num, mid) <= k){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return high+1;
    }

    private int checkGroup(int[] num, int max){
        size = 0; //자르는 개수
        dfs(num, root, max);
        return size+1;
    }

    private int dfs(int[] num, int cur, int max){
        int lv = 0, rv = 0;
        if(tree[cur].left != -1)
            lv = dfs(num, tree[cur].left, max);
        if(tree[cur].right != -1)
            rv = dfs(num, tree[cur].right, max);

        //자식 노드들과 자신의 값의 합이 max보다 작거나 같으면 자를 필요가 없다.
        if(num[cur] + lv + rv <= max)
            return num[cur] + lv + rv;

        //자신 노드들 중 제일 작은 값과 자신의 값의 합이 max보다 작거나 같으면 한개만 자르면 된다.
        if(num[cur] + Math.min(lv, rv) <= max){
            size+=1;
            return num[cur] + Math.min(lv, rv);
        }

        //둘 다 잘라야하는 경우
        //맨 밑단 노드 값이 max보다 작은 경우는 없습니다.
        //low가 제일 큰 노드를 기준으로 잡히기 때문에 무조건 첫번째 if에서 통과됩니다.
        size += 2;
        return num[cur];
    }

    private void setTree(int[] num, int[][] links){
        tree = new Node[num.length];
        parent = new int[num.length];

        Arrays.fill(parent, -1);

        for(int i=0; i<links.length; i++){
            tree[i] = new Node(links[i][0], links[i][1]);

            if(tree[i].left != -1) parent[tree[i].left] = i;
            if(tree[i].right != -1) parent[tree[i].right] = i;
        }

        for(int i=0; i<parent.length; i++){
            if(parent[i] == -1){
                root = i;
                break;
            }
        }
    }

    class Node{
        int left, right;

        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
}
