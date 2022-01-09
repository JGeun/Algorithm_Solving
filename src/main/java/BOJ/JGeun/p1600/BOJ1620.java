package BOJ.JGeun.p1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1620 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, M;
    static HashMap<String, Integer> pokemon = new HashMap<>();
    static String[] pokemonNames;
    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pokemonNames = new String[N+1];
        for(int i=1; i<=N; i++) {
            String name = br.readLine();
            pokemon.put(name, i);
            pokemonNames[i] = name;
        }
    }

    static void process() throws IOException{
        for(int i=0; i<M; i++){
            String input = br.readLine();
            try{
                sb.append(pokemonNames[Integer.parseInt(input)]).append('\n');
            }catch (NumberFormatException e){
                sb.append(pokemon.get(input)).append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
