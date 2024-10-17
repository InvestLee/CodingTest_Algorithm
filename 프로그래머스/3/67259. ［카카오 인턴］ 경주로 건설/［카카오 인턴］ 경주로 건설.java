import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int r = board.length;
        int c = board[0].length;
        int[][][] cost = new int[r][c][4];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0,0});
        q.offer(new int[]{0,0,0,1});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == r-1 && cur[1] == c-1){
                answer = Math.min(answer, cur[2]);
                continue;
            }
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= r || ny >= c || board[nx][ny] == 1){
                    continue;
                }
                if(i == cur[3] && cur[2]+100 < cost[nx][ny][i]){
                    cost[nx][ny][i] = cur[2]+100;
                    q.offer(new int[]{nx,ny,cost[nx][ny][i],i});
                } else if(i != cur[3] && cur[2]+600 < cost[nx][ny][i]){
                    cost[nx][ny][i] = cur[2]+600;
                    q.offer(new int[]{nx,ny,cost[nx][ny][i],i});
                }
            }
        }
        return answer;
    }
}