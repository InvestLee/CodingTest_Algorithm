import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Node{
    private int cf;
    private int cnt;

    public Node(int cf, int cnt){
        this.cf = cf;
        this.cnt = cnt;
    }

    public int getCf(){
        return this.cf;
    }

    public int getCnt(){
        return this.cnt;
    }
}

public class Main {
    public static int f, s, g, u, d;
    public static int[] building;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken())-1;
        g = Integer.parseInt(st.nextToken())-1;
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        building = new int[f];
        visited = new boolean[f];
        int[] dh = {u,-d};
        int result = -1;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(s,0));
        visited[s] = true;
        while(!q.isEmpty()){
            Node nowNode = q.poll();
            int height = nowNode.getCf();
            int count = nowNode.getCnt();
            if (height == g){
                result = count;
                break;
            }
            for(int i = 0; i < 2; i++){
                int newHeight = height + dh[i];
                if (newHeight < 0 || newHeight >= f) continue;
                if (!visited[newHeight]){
                    visited[newHeight] = true;
                    q.offer(new Node(newHeight, count+1));
                }
            }
        }
        if (result == -1) System.out.println("use the stairs");
        else System.out.println(result);
    }
}