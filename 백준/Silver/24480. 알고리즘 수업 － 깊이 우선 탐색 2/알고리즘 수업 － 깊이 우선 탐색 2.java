import java.io.*;
import java.util.*;

//24480 알고리즘 수업 - 깊이 우선 탐색 2
public class Main {

    public static int n, m, r, count = 1;
    public static int[] result;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        result = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        int u, v;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(r);

        for(int i = 1; i <= n; i++){
            bw.write(result[i] + "\n");
        }
        bw.flush();
    }

    public static void dfs(int cur){
        visited[cur] = true;
        result[cur] = count++;
        graph.get(cur).sort(Comparator.reverseOrder());
        for(Integer c : graph.get(cur)){
            if(!visited[c]){
                dfs(c);
            }
        }
    }
}
