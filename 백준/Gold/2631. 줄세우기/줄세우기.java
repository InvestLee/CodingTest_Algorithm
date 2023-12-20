import java.io.*;

//2631 줄세우기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] children = new int[n];
        for(int i = 0; i < n; i++) children[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[n];
        dp[0] = 1;

        int result = 0;
        for(int i = 1; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(children[i] > children[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            result = Math.max(result, dp[i]);
        }

        bw.write(n-result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}