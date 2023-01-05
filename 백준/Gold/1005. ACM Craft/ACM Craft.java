import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int t, n, m, a, b, winCondition;
    public static int[] inDegree;
    public static int[] cost;
    public static ArrayList<ArrayList<Integer>> graph;

    public static void topologySort(){
        int[] result = new int[n+1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++){
            result[i] = cost[i];
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int nowStudent = q.poll();
            for (Integer i : graph.get(nowStudent)){
                result[i] = Math.max(result[i], result[nowStudent] + cost[i]);
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        System.out.println(result[winCondition]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int j = 0; j < t; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            cost = new int[n+1];
            inDegree = new int[n+1];
            for (int i = 0; i <= n; i++) graph.add(new ArrayList<Integer>());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) cost[i] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                inDegree[b] += 1;
            }
            winCondition = Integer.parseInt(br.readLine());
            topologySort();
        }
    }
}