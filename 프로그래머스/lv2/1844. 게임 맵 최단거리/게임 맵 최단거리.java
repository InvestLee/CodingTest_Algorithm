import java.util.LinkedList;
import java.util.Queue;

class Node{ //좌표 상의 위치를 나타내기 위한 객체
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
}

class Solution {
    
    public static int dx[] = {-1,1,0,0}; //네 방향 이동
    public static int dy[] = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        int x = 0;
        int y = 0;
        int n = maps.length; //맵의 크기 지정
        int m = maps[0].length;
        q.offer(new Node(x,y));
        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.getIndex();
            y = node.getDistance();
            for (int i = 0; i < 4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0||nx>=n||ny<0||ny>=m) continue; //영역을 벗어나는 경우
                if(maps[nx][ny]==0) continue; //벽인 경우
                if(maps[nx][ny]==1) {
                    maps[nx][ny] = maps[x][y]+1;
                    q.offer(new Node(nx,ny));
                }
            }
        }
        int result = -1;
        if (maps[n-1][m-1] > 1) result = maps[n-1][m-1];
        
        return result;
    }
}