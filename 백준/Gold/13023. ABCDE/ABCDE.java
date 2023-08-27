import java.io.*;
import java.util.*;

//백준 13023 ABCDE
public class Main {

    public static boolean[] visited;
    public static ArrayList<Integer>[] relation;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        relation = new ArrayList[n];
        for(int i = 0; i < n; i++) relation[i] = new ArrayList<>();
        int a, b;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            relation[a].add(b);
            relation[b].add(a);
        }

        result = 0;
        for(int i = 0; i < n; i++){
            if(result == 0) dfs(i,1);
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int start, int cnt){
        if(cnt == 5){
            result = 1;
            return;
        }
        visited[start] = true;
        for(int next : relation[start]){
            if(!visited[next]) dfs(next, cnt+1);
        }
        visited[start] = false;
    }
}