import java.io.*;
import java.util.*;

//백준 3109 빵집
public class Main {

    public static char[][] graph;
    public static int r, c, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        graph = new char[r][c];
        for(int i = 0; i < r; i++) graph[i] = br.readLine().toCharArray();
        for(int i = 0; i < r; i++){
            if(check(i,0)) result++;
        }

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean check(int x, int y){
        graph[x][y] = '-';
        if(y == c-1) return true;
        if(x > 0 && graph[x-1][y+1] == '.'){
            if(check(x-1, y+1)) return true;
        }
        if(graph[x][y+1] == '.'){
            if(check(x, y+1)) return true;
        }
        if(x+1 < r && graph[x+1][y+1] == '.'){
            if(check(x+1, y+1)) return true;
        }
        return false;
    }
}
