import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

class Main{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] store = new int[n];

        for(int i=0; i<n; i++)
            store[i] = sc.nextInt();

        Stack<Integer> s = new Stack<>();
        ArrayList<String> st = new ArrayList<>();

        int index = 0;
        for(int i=1; i<=n; i++) {
            s.push(i); st.add("+");
            while(!s.empty() && s.peek() == store[index]) {
                s.pop();
                st.add("-");
                index++;
            }
        }
        if(!s.empty())
            System.out.println("NO\n");
        else{
            for(int i=0; i<st.size(); i++)
                System.out.println(st.get(i));
        }
    }
}