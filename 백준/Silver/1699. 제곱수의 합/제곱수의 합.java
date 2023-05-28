import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++) dp[i] = i;

        int temp;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < n; j++){
                if(j*j > i) break;
                temp = dp[i-j*j] + 1;
                if(dp[i] > temp) dp[i] = temp;
            }
        }

        bw.write(dp[n]+"");
        bw.flush();
        bw.close();
    }
}
