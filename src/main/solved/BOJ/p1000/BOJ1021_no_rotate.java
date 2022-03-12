package BOJ.p1000;

import java.io.*;
import java.util.*;

public class BOJ1021_no_rotate {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int ans = 0, start = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        List<Integer> nList = new ArrayList<>();
        int[] mArr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) mArr[i] = Integer.parseInt(st.nextToken());
        for(int i=1; i<=N; i++) nList.add(i);

        for(int i=0; i<M; i++){
            int index = nList.indexOf(mArr[i]);

            compareDist(start, index, nList.size());

            nList.remove(Integer.valueOf(mArr[i]));
            start = nList.size()==0 ? 0 : index%nList.size();
        }
        System.out.println(ans);
    }

    private static void compareDist(int start, int index, int len){
        if(start <= index){
            ans += Math.min(index - start, len - index + start);
        }else{
            ans += Math.min(start - index, len - start + index);
        }

        start = index;
    }
}