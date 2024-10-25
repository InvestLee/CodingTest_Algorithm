import java.util.*;

class Solution {
    public static char[] route = {'d', 'l', 'r', 'u'};
    public static int[] dx = {1, 0, 0, -1};
    public static int[] dy = {0, -1, 1, 0};
    public static int sn, sm, sr, sc, sk;
    public static StringBuilder sb;
    public static String answer = null;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int distance = Math.abs(x-r) + Math.abs(y-c);
        if((k - distance) % 2 == 1 || k < distance) return "impossible";
        sb = new StringBuilder();
        sn = n;
        sm = m;
        sr = r;
        sc = c;
        sk = k;
        dfs(x,y,0);
        return answer == null ? "impossible" : answer;
    }
    
    public static void dfs(int x, int y, int depth){
        if(answer != null) return;
        int distance = Math.abs(x-sr) + Math.abs(y-sc);
        if(depth + distance > sk) return;
        if(depth == sk){
            answer = sb.toString();
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx <= 0 || ny <= 0 || nx > sn || ny > sm) continue;
            sb.append(route[i]);
            dfs(nx,ny,depth+1);
            sb.delete(depth,depth+1);
        }
    }
}