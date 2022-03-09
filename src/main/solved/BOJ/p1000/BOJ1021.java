package BOJ.p1000;

import java.util.*;

public class BOJ1021 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] store = new int[M];
        for(int i=0; i<M; i++)
            store[i] = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=1; i<=N; i++)
            dq.add(i);

        int count = 0;
        for(int i=0; i<M; i++) {
            Iterator<Integer> it = dq.iterator();
            int index = 0;
            while(it.hasNext()){
                if(it.next() == store[i])
                    break;
                index +=1;
            }
            if(index <= dq.size()/2) {
                while(index != 0) {
                    dq.addLast(dq.pollFirst());
                    index -= 1;
                    count+=1;
                }
            }
            else {
                while(index != dq.size()) {
                    dq.addFirst(dq.pollLast());
                    index+=1;
                    count+=1;
                }
            }
            dq.pollFirst();
        }
        System.out.println(count);
    }
}
