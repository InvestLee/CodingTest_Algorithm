import java.io.*;
import java.util.*;

public class Main {
    static class Pos{
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static char[][] map;
    static Queue<Pos> jihunQ = new LinkedList<>();
    static Queue<Pos> fireQ = new LinkedList<>();
    static boolean[][] jihunVisited;
    static boolean[][] fireVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        jihunVisited = new boolean[N][M];
        fireVisited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'J') {
                    map[i][j] = '.';
                    jihunQ.add(new Pos(i, j));
                    jihunVisited[i][j] = true;
                } else if(map[i][j] == 'F') {
                    fireQ.add(new Pos(i, j));
                    fireVisited[i][j] = true;
                }
            }
        }

        bfs();
        System.out.println("IMPOSSIBLE");
    }

    private static void bfs() {
        int[][] dist = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = 0;

        while(!jihunQ.isEmpty()) {
            int jihunLen = jihunQ.size();
            int fireLen = fireQ.size();
            for(int i=0; i<fireLen; i++) {
                Pos fire = fireQ.poll();
                for(int d=0; d<4; d++) {
                    int nx = fire.x + dist[d][0];
                    int ny = fire.y + dist[d][1];

                    if(!isIn(nx, ny) || map[nx][ny] == '#' || fireVisited[nx][ny]) continue;
                    fireVisited[nx][ny] = true;
                    map[nx][ny] = 'F';
                    fireQ.add(new Pos(nx, ny));
                }
            }
            for(int i=0; i<jihunLen; i++) {
                Pos jihun = jihunQ.poll();
                for(int d=0; d<4; d++) {
                    int nx = jihun.x + dist[d][0];
                    int ny = jihun.y + dist[d][1];

                    if(!isIn(nx, ny)) {
                        time++;
                        System.out.println(time);
                        System.exit(0);
                    }

                    if(map[nx][ny] !='.' || jihunVisited[nx][ny]) continue;
                    jihunVisited[nx][ny] = true;
                    jihunQ.add(new Pos(nx, ny));
                }
            }

            time++;
        }
    }

    private static boolean isIn(int x, int y){
        return 0<=x && x<N && 0<=y && y<M;
    }
}