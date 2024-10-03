import java.util.*;

class Solution {
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,-1,0,1};
    public static boolean[][][] visited;
    public static int r, c;
    
    public int[] solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<>();
        r = grid.length;
        c = grid[0].length();
        visited = new boolean[r][c][4];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                for(int k = 0; k < 4; k++){
                    if(!visited[i][j][k]){
                        answer.add(cycle(grid,i,j,k));
                    }
                }
            }
        }
        
        return answer.stream().sorted().mapToInt(a->a).toArray();
    }
    
    public static int cycle(String[] grid, int i, int j, int k){
        int len = 0;
        while(!visited[i][j][k]){
            visited[i][j][k] = true;
            len++;
            
            if(grid[i].charAt(j) == 'L'){
                k = (k + 3) % 4;
            } else if(grid[i].charAt(j) == 'R'){
                k = (k + 1) % 4;
            }
            
            i = (i+dx[k]+r) % r;
            j = (j+dy[k]+c) % c;
        }
        return len;
    }
}