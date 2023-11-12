import java.io.*;

//백준 2133 타일 채우기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n % 2 == 1) bw.write(0+"");
        else{
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[2] = 3;
            for(int i = 4; i <= n; i += 2){
                dp[i] = dp[i-2] * dp[2];
                for(int j = i - 4; j >= 0; j -= 2){
                    dp[i] += (dp[j] * 2);
                }
            }
            bw.write(dp[n]+"");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}