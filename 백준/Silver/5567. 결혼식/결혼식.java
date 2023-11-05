import java.io.*;
import java.util.*;

//백준 5567 결혼식
public class Main {

    public static int n, m, a, b, result;
    public static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i <= n; i++) map.add(new ArrayList<>());
        visited = new boolean[n+1];
        visited[1] = true;

        StringTokenizer st;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        dfs(0, 1);

        result = 0;
        for(int i = 2; i < n+1; i++){
            if(visited[i]) result++;
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int depth, int num){
        if(depth == 2) return;
        for(int i : map.get(num)){
            visited[i] = true;
            dfs(depth+1, i);
        }
    }
}