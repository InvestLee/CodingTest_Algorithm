import java.io.*;
import java.util.*;

//10709 기상캐스터
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][w];

        String str;
        char temp;
        for(int i = 0; i < h; i++){
            str = br.readLine();
            for(int j = 0; j < w; j++){
                temp = str.charAt(j);
                if(temp == 'c') map[i][j] = 0;
                else map[i][j] = -1;
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 1; j < w; j++){
                if(map[i][j] == -1 && map[i][j-1] != -1){
                    map[i][j] = map[i][j-1] + 1;
                }
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}