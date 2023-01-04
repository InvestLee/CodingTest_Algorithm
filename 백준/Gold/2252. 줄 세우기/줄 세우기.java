import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int n, m, a, b;
    public static int[] inDegree;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void topologySort(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) if(inDegree[i] == 0) q.offer(i);

        while(!q.isEmpty()){
            int nowStudent = q.poll();
            result.add(nowStudent);
            for (int i = 0; i < graph.get(nowStudent).size(); i++){
                inDegree[graph.get(nowStudent).get(i)] -= 1;
                if (inDegree[graph.get(nowStudent).get(i)] == 0) q.offer(graph.get(nowStudent).get(i));
            }
        }

        for (int i = 0; i < result.size(); i++) System.out.print(result.get(i)+" ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inDegree = new int[n+1];
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<Integer>());
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            inDegree[b] += 1;
        }
        topologySort();
    }
}