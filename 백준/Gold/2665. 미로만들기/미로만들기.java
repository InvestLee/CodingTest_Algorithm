import java.io.*;
import java.util.*;

public class Main {
    static int map[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static int dist[][];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = str.charAt(j)-'0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();


        System.out.println(dist[N-1][N-1]);	
    }
    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));   
        dist[0][0] = 0;

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i=0;i<4;i++){   
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];

                if(nextX >=0 && nextY >= 0 && nextX < N && nextY < N){
                    if(dist[nextX][nextY] > dist[now.x][now.y]){
                        if(map[nextX][nextY] == 1) dist[nextX][nextY] = dist[now.x][now.y];
                        else dist[nextX][nextY] = dist[now.x][now.y]+1; 
                        q.add(new Node(nextX,nextY));
                    }
                }
            }
        }
    }


    public static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}