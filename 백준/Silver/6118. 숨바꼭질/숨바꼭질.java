import java.io.*;
import java.util.*;

//2240 자두나무
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        int a, b;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] distance = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int cur, maxDistance = 0;
        while(!q.isEmpty()){
            cur = q.poll();
            for(Integer i : graph[cur]){
                if(distance[i] != 0 || i == 1) continue;
                distance[i] = distance[cur] + 1;
                q.offer(i);
                maxDistance = distance[i];
            }
        }

        int cnt = 0;
        int result = 0;
        for(int i = 1; i <= n; i++){
            if(maxDistance == distance[i]){
                cnt++;
                if(result == 0) result = i;
            }
        }
        bw.write(result+" "+maxDistance+" "+cnt);
        bw.flush();
    }
}
