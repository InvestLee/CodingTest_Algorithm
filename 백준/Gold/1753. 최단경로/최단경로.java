import java.io.*;
import java.util.*;

public class Main {
    public static int[] dist;
    public static ArrayList<Node>[] graph;
    public static int v, e, k;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        graph = new ArrayList[v+1];
        dist = new int[v+1];
        for(int i = 0; i <= v; i++){
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o1.weight - o2.weight);
        dist[k] = 0;
        pq.offer(new Node(k,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            for(int i = 0; i < graph[cur.end].size(); i++){
                Node next = graph[cur.end].get(i);
                if(cur.weight + next.weight < dist[next.end]){
                    dist[next.end] = cur.weight + next.weight;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }

        for(int i = 1; i <= v; i++){
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}

class Node{
    int end;
    int weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
}