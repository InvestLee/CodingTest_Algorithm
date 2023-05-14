import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] olympic = new int[n+1][3];
        int country;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            country = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 3; j++) olympic[country][j] = Integer.parseInt(st.nextToken());
        }

        int rank = 1;
        for(int i = 1; i <= n; i++){
            if(i == k) continue;
            if(olympic[i][0] > olympic[k][0]) rank++;
            else if(olympic[i][0] == olympic[k][0]){
                if(olympic[i][1] > olympic[k][1]) rank++;
                else if(olympic[i][1] == olympic[k][1]){
                    if(olympic[i][2] > olympic[k][2]) rank++;
                }
            }
        }
        System.out.println(rank);
    }
}
