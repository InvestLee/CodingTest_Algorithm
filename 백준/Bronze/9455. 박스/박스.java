import java.io.*;
import java.util.StringTokenizer;

//9455 박스
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int m, n, result;
        StringTokenizer st;
        int[][] map;
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            map = new int[m][n];
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[j][i] == 1){
                        for(int k = j+1; k < m; k++){
                            if(map[k][i] == 0) result++;
                        }
                    }
                }
            }
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}