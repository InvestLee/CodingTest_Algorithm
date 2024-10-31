import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int len = board.length;
        Queue<Robot> q = new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        boolean[][][] visited = new boolean[len][len][2];
        q.offer(new Robot(0,0,0,1,0,0));
        while(!q.isEmpty()){
            Robot cur = q.poll();
            if(cur.r1 < 0 || cur.c1 < 0 || cur.r1 >= len || cur.c1 >= len ||
            cur.r2 < 0 || cur.c2 < 0 || cur.r2 >= len || cur.c2 >= len ||
            board[cur.r1][cur.c1] == 1 || board[cur.r2][cur.c2] == 1 ||
            (visited[cur.r1][cur.c1][cur.v] && visited[cur.r2][cur.c2][cur.v])
            ) continue;
            if((cur.r1 == len - 1 && cur.c1 == len -1)
            || (cur.r2 == len - 1 && cur.c2 == len -1)) return cur.t;
            visited[cur.r1][cur.c1][cur.v] = true;
            visited[cur.r2][cur.c2][cur.v] = true;
            
            for(int i = 0; i < 4; i++){
                int nx1 = cur.r1 + dx[i];
                int nx2 = cur.r2 + dx[i];
                int ny1 = cur.c1 + dy[i];
                int ny2 = cur.c2 + dy[i];
                q.offer(new Robot(nx1, ny1, nx2, ny2, cur.t+1, cur.v));
            }
            
            if(cur.v == 0){
                if(cur.r1-1 >= 0 
                   && board[cur.r1-1][cur.c1] == 0 
                   && board[cur.r2-1][cur.c2] == 0){
                    q.offer(new Robot(cur.r1-1,cur.c2,cur.r2,cur.c2,cur.t+1,1));
                    q.offer(new Robot(cur.r1,cur.c1,cur.r2-1,cur.c1,cur.t+1,1));
                }
                if(cur.r1+1 < len 
                   && board[cur.r1+1][cur.c1] == 0 
                   && board[cur.r2+1][cur.c2] == 0){
                    q.offer(new Robot(cur.r1+1,cur.c2,cur.r2,cur.c2,cur.t+1,1));
                    q.offer(new Robot(cur.r1,cur.c1,cur.r2+1,cur.c1,cur.t+1,1));
                }
            }
            else{
                if(cur.c1-1 >= 0 
                   && board[cur.r1][cur.c1-1] == 0 
                   && board[cur.r2][cur.c2-1] == 0){
                    q.offer(new Robot(cur.r2, cur.c1-1, cur.r2, cur.c2, cur.t+1, 0));
                    q.offer(new Robot(cur.r1, cur.c1, cur.r1, cur.c2-1, cur.t+1, 0));
                }
                if(cur.c1+1 < len 
                   && board[cur.r1][cur.c1+1] == 0 
                   && board[cur.r2][cur.c2+1] == 0){
                    q.offer(new Robot(cur.r2, cur.c1+1, cur.r2, cur.c2, cur.t+1, 0));
                    q.offer(new Robot(cur.r1, cur.c1, cur.r1, cur.c2+1, cur.t+1, 0));
                }
            }
        }
        return -1;
    }
    
    class Robot{
        int r1;
        int c1;
        int r2;
        int c2;
        int t;
        int v;
        public Robot(int r1, int c1, int r2, int c2, int t, int v){
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.t = t;
            this.v = v;
        }
    }
}