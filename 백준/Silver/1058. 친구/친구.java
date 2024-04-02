import java.io.*;
import java.util.*;

//1058 친구
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[51][51];
        String temp;
        for(int i = 1; i <= n; i++){
            temp = br.readLine();
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                cost[i][j] = temp.charAt(j-1) == 'Y' ? 1 : 100000000;
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j<= n; j++){
                for(int k = 1; k<= n; k++){
                    if(j == k) continue;
                    cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);
                }
            }
        }

        int cnt, result = 0;
        for(int i = 1; i <= n; i++){
            cnt = 0;
            for(int j = 1; j <= n; j++){
                if(cost[i][j] == 2 || cost[i][j] == 1) cnt++;
            }
            result = Math.max(cnt, result);
        }
        bw.write(result+"");
        bw.flush();
    }
}
