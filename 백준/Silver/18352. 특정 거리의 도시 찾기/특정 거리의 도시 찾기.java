import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{

    private int index;
    private int distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex(){
        return this.index;
    }

    public int getDistance(){
        return this.distance;
    }

    @Override
    public int compareTo(Node o) {
        if(this.distance < o.distance){
            return -1;
        }
        return 1;
    }
}

public class Main {

    public static int n, m, k, x;
    public static ArrayList<ArrayList<Node>> graph;
    public static int[] d;

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        d[start] = 0;
        int cost, now, dist;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            now = node.getIndex();
            dist = node.getDistance();
            if(d[now] < dist) continue;
            for(int i = 0; i < graph.get(now).size(); i++){
                cost = d[now] + graph.get(now).get(i).getDistance();
                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        d = new int[n+1];

        int a, b;
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,1));
        }
        Arrays.fill(d, Integer.MAX_VALUE);
        dijkstra(x);

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 1; i <= n; i++) if(d[i] == k) result.add(i);
        if(result.size() == 0) bw.write(-1+"");
        else for(int i = 0; i < result.size(); i++) bw.write(result.get(i)+"\n");
        bw.flush();
        bw.close();
    }
}
