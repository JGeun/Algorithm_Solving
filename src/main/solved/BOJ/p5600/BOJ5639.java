import java.io.*;
import java.util.*;

// 1. 전위순회한 결과로 트리를 만든다
// 1-1. 루트값을 저장하고 루트값보다 큰 값이 나올 때까진 무조건 왼쪽 트리 / 큰 값이 나오면 이제 오른쪽 트리
// 2. 트리가 연결되었으면 후위순회를 통해 값을 출력한다.
class Main {

    private static Node root;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        postOrder(root);
    }

    private static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.weight);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int weight = Integer.parseInt(br.readLine());
        root = new Node(weight);

        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) break;
            root.addNode(Integer.parseInt(input));
        }
    }

    private static class Node {
        int weight;
        Node left, right;

        public Node(int weight) {
            this.weight = weight;
            left = null;
            right = null;
        }

        public void addNode(int weight) {
            Node curNode = this;
            while (true) {
                if (curNode.weight >= weight) {
                    if (curNode.left == null) {
                        curNode.left = new Node(weight);
                        return;
                    } else {
                        curNode = curNode.left;
                    }
                } else {
                    if (curNode.right == null) {
                        curNode.right = new Node(weight);
                        return;
                    } else {
                        curNode = curNode.right;
                    }
                }
            }
        }
    }
}