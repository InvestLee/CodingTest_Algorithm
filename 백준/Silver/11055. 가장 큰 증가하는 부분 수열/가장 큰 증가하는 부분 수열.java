import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j < i; j++){
                if(arr[j] < arr[i]) dp[i] = Math.max(dp[j]+arr[i], dp[i]);
            }
        }

        int result = 0;
        for (int i = 0; i <= n; i++) result = Math.max(result,dp[i]);
        System.out.println(result);
    }
}