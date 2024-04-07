import java.io.*;
import java.util.*;

//1446 지름길
public class Main {

    public static int n, d;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] distance;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= 10001; i++) graph.add(new ArrayList<>());
        distance = new int[10001];
        for(int i = 0; i < 10001; i++) distance[i] = i;

        int a, b, w;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,w));
        }
        dijkstra(0);
        bw.write(distance[d]+"");
        bw.flush();
    }

    public static void dijkstra(int start){
        if(start > d) return;
        if(distance[start+1] > distance[start] + 1) distance[start+1] = distance[start] + 1;
        for(int i = 0; i < graph.get(start).size(); i++){
            if(distance[start]+graph.get(start).get(i).weight <
                    distance[graph.get(start).get(i).node]){
                distance[graph.get(start).get(i).node]
                        = distance[start]+graph.get(start).get(i).weight;
            }
        }
        dijkstra(start+1);
    }
}

class Node{
    int node;
    int weight;

    Node(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
