class Solution {
    
    public int r, c;
    public int[][] map, tar;
    public int min = Integer.MAX_VALUE;
    
    public int solution(int[][] beginning, int[][] target) {
        r = beginning.length;
        c = beginning[0].length;
        map = beginning;
        tar = target;
        dfs(0,0);
        return min == Integer.MAX_VALUE? -1 : min;
    }
    
    public void dfs(int row, int cnt){
        if(r == row){
            int result = cnt;
            for(int col = 0; col < c; col++){
                if(isDiffCol(col) == r) result++;
                else if(isDiffCol(col) != 0) return;
            }
            min = Math.min(min, result);
            return;
        }
        reverse(row);
        dfs(row+1, cnt+1);
        reverse(row);
        dfs(row+1, cnt);
    }
    
    public int isDiffCol(int col){
        int cnt = 0;
        for(int i = 0; i < r; i++){
            if(map[i][col] != tar[i][col]) cnt++;
        }
        return cnt;
    }
    
    public void reverse(int row){
        for(int i = 0; i < c; i++){
            if(map[row][i] == 0) map[row][i] = 1;
            else map[row][i] = 0;
        }
    }
}