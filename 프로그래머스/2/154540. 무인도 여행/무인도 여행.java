import java.util.*;

class Solution {
    
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static String[][] map;
    public static boolean[][] visited;
    public static int xlen, ylen;
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        PriorityQueue<Integer> pq = new PriorityQueue();
        xlen = maps.length;
        ylen = maps[0].length();
        
        map = new String[xlen][ylen];
        for(int i = 0; i < xlen; i++){
            for(int j = 0; j < ylen; j++){
                map[i][j] = maps[i].charAt(j)+"";
            }
        }
        visited = new boolean[xlen][ylen];
        
        for(int i = 0; i < xlen; i++){
            for(int j = 0; j < ylen; j++){
                if(!visited[i][j] && !map[i][j].equals("X")){
                    pq.offer(new Integer(bfs(i,j)));
                }
            }
        }
        
        if(pq.size() == 0){
            answer = new int[]{-1};
        } else {
            answer = new int[pq.size()];
            int idx = 0;
            while(!pq.isEmpty()){
                answer[idx] = pq.poll();
                idx++;
            }
        }
        
        return answer;
    }
    
    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList();
        visited[x][y] = true;
        int sum = Integer.parseInt(map[x][y]);
        q.offer(new int[]{x,y});
        
        int[] cur;
        int nx, ny;
        while(!q.isEmpty()){
            cur = q.poll();
            x = cur[0];
            y = cur[1];
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= xlen || ny >= ylen 
                   || map[nx][ny].equals("X")){
                    continue;
                }
                if(!visited[nx][ny]){
                    sum += Integer.parseInt(map[nx][ny]);
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return sum;
    }
}