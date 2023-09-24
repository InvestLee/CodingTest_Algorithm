import java.io.*;
import java.util.*;

//백준 15685 드래곤 커브
public class Main {

    public static int dy[] = {0,-1,0,1};
    public static int dx[] = {1,0,-1,0};
    public static boolean map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new boolean[101][101];
        int x, y, d, g;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            dragonCurve(x,y,d,g);
        }

        int result = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) result++;
            }
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dragonCurve(int x, int y, int d, int g){
        ArrayList<Integer> direction = new ArrayList<>();
        direction.add(d);
        for(int i = 0; i < g; i++){
            for(int j = direction.size() - 1; j >= 0; j--){
                direction.add((direction.get(j)+1)%4);
            }
        }

        map[y][x] = true;
        for(int i = 0; i < direction.size(); i++){
            x += dx[direction.get(i)];
            y += dy[direction.get(i)];
            map[y][x] = true;
        }
    }
}