import java.io.*;
import java.util.*;

//6593 상범 빌딩
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int l, r, c, nx, ny, nz, isEscape;
        char[][][] map;
        boolean[][][] visited;
        String temp;
        Queue<int[]> queue;
        int[] dx = {-1,1,0,0,0,0};
        int[] dy = {0,0,-1,1,0,0};
        int[] dz = {0,0,0,0,-1,1};
        int[] xyz;
        while(true){
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(l == 0 && r == 0 && c == 0) break;
            map = new char[l][r][c];
            visited = new boolean[l][r][c];
            queue = new LinkedList<>();
            for(int i = 0; i < l; i++){
                for(int j = 0; j < r; j++){
                    temp = br.readLine();
                    if(temp.equals("")) temp = br.readLine();
                    for(int k = 0; k < c; k++){
                        map[i][j][k] = temp.charAt(k);
                        if(map[i][j][k] == 'S'){
                            queue.offer(new int[]{i, j, k, 0});
                            visited[i][j][k] = true;
                        }
                    }
                }
            }

            isEscape = 0;
            while(!queue.isEmpty()){
                xyz = queue.poll();
                for(int i = 0; i < 6; i++){
                    nx = xyz[0] + dx[i];
                    ny = xyz[1] + dy[i];
                    nz = xyz[2] + dz[i];
                    if(nx < 0 || ny < 0 || nz < 0 || nx >= l || ny >= r || nz >= c) continue;
                    if(map[nx][ny][nz] == 'E'){
                        bw.write("Escaped in "+(xyz[3]+1)+" minute(s).\n");
                        isEscape = 1;
                        queue.clear();
                        break;
                    }
                    if(!visited[nx][ny][nz] && map[nx][ny][nz] == '.'){
                        visited[nx][ny][nz] = true;
                        queue.offer(new int[]{nx, ny, nz, xyz[3]+1});
                    }
                }
            }
            if(isEscape == 0) bw.write("Trapped!\n");
            temp = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}