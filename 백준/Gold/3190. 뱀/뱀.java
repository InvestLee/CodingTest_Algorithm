import java.io.*;
import java.util.*;

//3190 뱀
public class Main {
    public static int n, k, l, nx, ny, result, dir;
    public static int[][] map;
    public static int[] xy, temp;
    public static ArrayList<String[]> dirList;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static Deque<int[]> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        map[1][1] = 1;
        StringTokenizer st;
        int row, col;
        while(k-- > 0){
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            map[row][col] = 2;
        }

        l = Integer.parseInt(br.readLine());
        dirList = new ArrayList<>();
        String x, c;
        dirList.add(new String[]{"0", "N"});
        for(int i = 0; i < l; i++){
            st = new StringTokenizer(br.readLine());
            x = st.nextToken();
            c = st.nextToken();
            dirList.add(new String[]{x, c});
        }
        result = 0;
        dir = 0;
        gameStart();

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void gameStart(){
        deque = new LinkedList<>();
        deque.add(new int[]{1, 1});
        int diffTime;
        for(int i = 1; i <= l; i++){
            diffTime = Integer.parseInt(dirList.get(i)[0]) - Integer.parseInt(dirList.get(i-1)[0]);
            for(int j = 0; j < diffTime; j++){
                if(snakeMove()) return;
            }
            if(dirList.get(i)[1].equals("D")) dir = (dir+1) % 4;
            else if(dir-1 == -1) dir = 3;
            else dir -= 1;
        }
        while(true){
            if(snakeMove()) return;
        }
    }

    public static boolean snakeMove(){
        xy = deque.peekFirst();
        nx = xy[0] + dx[dir];
        ny = xy[1] + dy[dir];
        result++;
        if(nx < 1 || ny < 1 || nx > n || ny > n || map[nx][ny] == 1){
            return true;
        }
        if(map[nx][ny] == 0){
            temp = deque.pollLast();
            map[temp[0]][temp[1]] = 0;
        }
        map[nx][ny] = 1;
        deque.offerFirst(new int[]{nx, ny});
        return false;
    }
}