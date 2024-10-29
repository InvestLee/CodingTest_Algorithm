import java.util.*;

class Solution {
    public static int[][] map;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        for(int[] r : rectangle){
            draw(r[0]*2, r[1]*2, r[2]*2, r[3]*2);
        }
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        boolean[][] visited = new boolean[101][101];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{characterY*2, characterX*2, 0});
        visited[characterY*2][characterX*2] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0; i < 4; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(nx == itemX*2 && ny == itemY*2) return (now[2] + 1) / 2;
                if(nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                if(!visited[ny][nx] && map[ny][nx] == 2){
                    q.offer(new int[]{ny, nx, now[2]+1});
                    visited[ny][nx] = true;
                }
            }
        }
        
        return -1;
    }
    
    public static void draw(int x1, int y1, int x2, int y2){
        for(int i = y1; i <= y2; i++){
            for(int j = x1; j <= x2; j++){
                if(map[i][j]==1){
                  continue;  
                } 
                if(i==y1||i==y2||j==x1||j==x2){
                    map[i][j]=2;
                } else {
                    map[i][j]=1;
                }
            }
        }
    }
}