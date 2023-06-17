import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, mod, bit;
        n = Integer.parseInt(br.readLine());
        mod = 1000000000;
        long result = 0;

        long[][][] dp = new long[n+1][10][1<<10];

        for(int i = 1; i <= 9; i++) dp[1][i][1<<i] = 1;

        for(int i = 2; i < n+1; i++){
            for(int j = 0;j < 10; j++){
                for(int k = 0; k < (1<<10); k++){
                    bit = k | (1<<j);
                    if(j == 0) dp[i][j][bit] += dp[i-1][j+1][k] % mod;
                    else if(j == 9) dp[i][j][bit] += dp[i-1][j-1][k] % mod;
                    else dp[i][j][bit] += (dp[i-1][j+1][k] + dp[i-1][j-1][k]) % mod;
                    dp[i][j][bit] %= mod;
                }
            }
        }
        for(int i = 0; i <= 9; i++){
            result += dp[n][i][(1<<10)-1] % mod;
            result %= mod;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}