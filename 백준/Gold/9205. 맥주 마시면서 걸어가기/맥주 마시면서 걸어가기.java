import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Node{
    private int x;
    private int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}

public class Main {
    public static ArrayList<Integer> house, festival;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visited;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++){
            n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            house = new ArrayList<>();
            house.add(Integer.parseInt(st.nextToken()));
            house.add(Integer.parseInt(st.nextToken()));

            graph = new ArrayList<>();
            for (int j = 0; j < n; j++){
                ArrayList xyList = new ArrayList<>();
                st = new StringTokenizer(br.readLine());
                xyList.add(Integer.parseInt(st.nextToken()));
                xyList.add(Integer.parseInt(st.nextToken()));
                graph.add(xyList);
            }

            st = new StringTokenizer(br.readLine());
            festival = new ArrayList<>();
            festival.add(Integer.parseInt(st.nextToken()));
            festival.add(Integer.parseInt(st.nextToken()));

            visited = new boolean[n];
            bfs();
        }
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(house.get(0), house.get(1)));
        while(!q.isEmpty()){
            Node current = q.poll();
            int x = current.getX();
            int y = current.getY();
            if (Math.abs(x-festival.get(0))+Math.abs(y-festival.get(1)) <= 1000){
                System.out.println("happy");
                return;
            }
            for (int k = 0; k < n; k++){
                if (!visited[k]){
                    int nextX = graph.get(k).get(0);
                    int nextY = graph.get(k).get(1);
                    if (Math.abs(x-nextX)+Math.abs(y-nextY) <= 1000){
                        visited[k] = true;
                        q.add(new Node(nextX, nextY));
                    }
                }
            }
        }
        System.out.println("sad");
        return;
    }
}