import java.io.*;
import java.util.*;

//2422 한윤정이 이탈리아에 가서 아이스크림을 사먹는데
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] pairs = new boolean[n+1][n+1];
        int a, b;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            pairs[a][b] = true;
            pairs[b][a] = true;
        }

        int result = 0;
        for(int i = 1; i <= n; i++){
            for(int j = i+1; j <= n; j++){
                if(pairs[i][j]) continue;
                for(int k = j+1; k <= n; k++){
                    if(pairs[j][k] || pairs[i][k]) continue;
                    result++;
                }
            }
        }
        bw.write(result+"");
        bw.flush();
    }
}
