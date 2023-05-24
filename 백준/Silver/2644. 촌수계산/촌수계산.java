import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Node{
    private int node;
    private int cnt;

    public Node(int node, int cnt){
        this.node = node;
        this.cnt = cnt;
    }

    public int getNode(){
        return this.node;
    }

    public int getCnt(){
        return this.cnt;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int targetX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        int x, y, curNode, curCnt;
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        boolean[] visited = new boolean[n+1];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(targetX, 0));
        visited[targetX] = true;
        Node currentNode;

        int result = -1;
        while(!q.isEmpty()){
            currentNode = q.poll();
            curNode = currentNode.getNode();
            curCnt = currentNode.getCnt();
            for(int i : graph.get(curNode)){
                if(i == targetY){
                    result = curCnt + 1;
                    q.clear();
                    break;
                }
                if(!visited[i]){
                    q.offer(new Node(i,curCnt+1));
                    visited[i] = true;
                }
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
