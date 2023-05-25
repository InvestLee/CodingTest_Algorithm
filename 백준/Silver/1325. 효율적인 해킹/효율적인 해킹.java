import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        int a, b, hackingCount;
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }

        int maxHacking = 0;
        for(int i = 1; i <= n; i++){
            hackingCount = bfs(i);
            hashMap.put(i,hackingCount);
            if (maxHacking < hackingCount) maxHacking = hackingCount;
        }

        for(int i : hashMap.keySet()){
            if(hashMap.get(i) == maxHacking) bw.write(i+" ");
        }

        bw.flush();
        bw.close();
    }

    public static int bfs(int i){
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        int comNum;
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;
        while(!q.isEmpty()){
            comNum = q.poll();
            for(int num : graph.get(comNum)){
                if(!visited[num]){
                    q.offer(num);
                    visited[num] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
