import java.util.*;

class Solution {
    
    public static String[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int r, c;
    
    public int solution(String[] board) {
        int answer = -1;
        r = board.length;
        c = board[0].length();
        map = new String[r][c];
        visited = new boolean[r][c];
        
        int sx = 0; 
        int sy = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                map[i][j] = board[i].charAt(j)+"";
                if(map[i][j].equals("R")){
                    sx = i;
                    sy = j;
                }
            }
        }
        
        answer = bfs(sx, sy);
        
        return answer;
    }
    
    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y,0});
        visited[x][y] = true;
        
        int[] now;
        int cnt, nx, ny;
        while(!q.isEmpty()){
            now = q.poll();
            x = now[0];
            y = now[1];
            cnt = now[2];
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                while(nx >= 0 && ny >= 0 && nx < r && ny < c
                     && !map[nx][ny].equals("D")){
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];
                if(map[nx][ny].equals("G")){
                    return cnt+1;
                }
                if(!visited[nx][ny]){
                    q.offer(new int[]{nx,ny,cnt+1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}