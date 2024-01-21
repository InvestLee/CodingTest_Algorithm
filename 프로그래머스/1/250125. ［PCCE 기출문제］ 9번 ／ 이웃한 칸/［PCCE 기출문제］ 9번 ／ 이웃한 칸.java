import java.util.*;

class Solution {
    
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int nx, ny;
        for(int i = 0; i < 4; i++){
            nx = h + dx[i];
            ny = w + dy[i];
            if(nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) continue;
            if(board[h][w].equals(board[nx][ny])) answer++;
        }
        
        return answer;
    }
}