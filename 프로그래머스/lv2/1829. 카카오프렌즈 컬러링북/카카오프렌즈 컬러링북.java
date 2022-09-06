import java.util.Queue;
import java.util.LinkedList;

class Node{ //큐 노드 정의
    private int n_x;
    private int n_y;
    
    public Node(int n_x, int n_y){
        this.n_x = n_x;
        this.n_y = n_y;
    }
    public int getN_x(){
        return this.n_x;
    }
    public int getN_y(){
        return this.n_y;
    }
}

class Solution {
    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};
    public static boolean[][] visited; //무한 루프 방지 방문처리
    public static int[][] p; //bfs함수 정의를 위함
    
    //현재 그림의 영역을 찾는 bfs
    public static int bfs(int m, int n, int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y] = true;
        int cnt = 1;
        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.getN_x();
            y = node.getN_y();
            for (int i = 0; i < 4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(p[nx][ny]==p[x][y] && !visited[nx][ny]){
                    q.offer(new Node(nx,ny));
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int x = 0;
        int y = 0;
        p = picture;
        visited = new boolean[m][n];
        
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        
        for (int i = 0; i <m ; i++){
            for (int j = 0; j < n; j++){
                if(picture[i][j] > 0 && !visited[i][j]){
                    maxSizeOfOneArea = Math.max(bfs(m,n,i,j),maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}