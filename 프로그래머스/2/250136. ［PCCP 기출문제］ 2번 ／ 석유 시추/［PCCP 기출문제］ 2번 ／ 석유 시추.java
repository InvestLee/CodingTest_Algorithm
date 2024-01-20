import java.util.*;

class Solution {
    
    int[][] land;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    boolean[][] visited;
    int n, m, cnt;
    
    public int solution(int[][] land) {
        this.land = land;
        this.n = land.length;
        this.m = land[0].length;
        this.visited = new boolean[n][m];
        int answer = 0;
        int idx = 2;
        
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        for(int j = 0; j < m; j++){
            for(int i = 0; i < n; i++){
                this.cnt = 0;
                if(!visited[i][j] && land[i][j] == 1){
                    bfs(i,j,idx);
                    hashmap.put(idx, cnt);
                    idx++;
                } 
            }
        }
        
        HashSet<Integer> hashset;
        for(int j = 0; j < m; j++){
            hashset = new HashSet<>();
            for(int i = 0; i < n; i++){
                if(land[i][j] >= 2){
                    hashset.add(land[i][j]);
                } 
            }
            cnt = 0;
            for(int i : hashset){
                cnt += hashmap.get(i);
            }
            answer = Math.max(answer,cnt);
        }
        
        return answer;
    }
    
    public void bfs(int x, int y, int idx){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        cnt++;
        land[x][y] = idx;
        while(!q.isEmpty()){
            int[] xy = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];
                if(nx < 0 || ny < 0|| nx >= n || ny >= m) continue;
                if(!visited[nx][ny] && land[nx][ny] == 1){
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    cnt++;
                    land[nx][ny] = idx;
                }
            }
        }
    }
}