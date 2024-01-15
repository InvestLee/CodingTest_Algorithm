import java.io.*;

//2670 연속부분최대곱
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n+1];
        double[] dp = new double[n+1];
        double result = 0;
        for(int i = 1; i <= n; i++){
            arr[i] = Double.parseDouble(br.readLine());
            dp[i] = Math.max(arr[i], dp[i-1] * arr[i]);
            result = Math.max(result, dp[i]);
        }
        bw.write(String.format("%.3f",result));
        bw.flush();
        bw.close();
        br.close();
    }
}