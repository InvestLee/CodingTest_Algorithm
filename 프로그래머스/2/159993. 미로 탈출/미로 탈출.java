import java.util.*;

class Solution {
    
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static String[][] map;
    public static boolean[][] visited1;
    public static boolean[][] visited2;
    public static int xlen, ylen;
    
    public int solution(String[] maps) {
        int answer = 0;
        xlen = maps.length;
        ylen = maps[0].length();
        map = new String[xlen][ylen];
        visited1 = new boolean[xlen][ylen];
        visited2 = new boolean[xlen][ylen];
        int[] start = {};
        int[] lever = {};
        for(int i = 0; i < xlen; i++){
            for(int j = 0; j < ylen; j++){
                map[i][j] = maps[i].charAt(j)+"";
                if(map[i][j].equals("S")){
                    start = new int[]{i,j,0};
                } else if(map[i][j].equals("L")){
                    lever = new int[]{i,j,0};
                }
            }
        }
        int cnt1 = bfs(start, 0);
        int cnt2 = bfs(lever, 1);
        if(cnt1 == -1 || cnt2 == -1){
            answer = -1;
        } else {
            answer = cnt1 + cnt2;
        }
        
        return answer;
    }
    
    public static int bfs(int[] s, int flag){
        Queue<int[]> q = new LinkedList();
        q.offer(s);
        if(flag == 0) visited1[s[0]][s[1]] = true;
        else visited2[s[0]][s[1]] = true;
        
        int[] cur;
        int x, y, cnt, nx, ny;
        while(!q.isEmpty()){
            cur = q.poll();
            x = cur[0];
            y = cur[1];
            cnt = cur[2];
            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= xlen || ny >= ylen 
                   || map[nx][ny].equals("X")){
                    continue;
                }
                if(flag == 0){
                    if(map[nx][ny].equals("L")){
                        return cnt+1;
                    }
                    if(!visited1[nx][ny]){
                        visited1[nx][ny] = true;
                        q.offer(new int[]{nx,ny,cnt+1});
                    }
                }
                else{
                    if(map[nx][ny].equals("E")){
                        return cnt+1;
                    }
                    if(!visited2[nx][ny]){
                        visited2[nx][ny] = true;
                        q.offer(new int[]{nx,ny,cnt+1});
                    }
                }
                
            }
        }
        
        return -1;
    }
}